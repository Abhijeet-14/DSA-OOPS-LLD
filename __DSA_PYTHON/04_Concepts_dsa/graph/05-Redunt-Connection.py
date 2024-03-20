""" Problem: [https://leetcode.com/problems/redundant-connection/]
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example:
    Input: edges = [[1,2],[1,3],[2,3]]
    Output: [2,3]

    Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    Output: [1,4]
"""


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        """
        TC - O(N**2), as O(V+E for DFS, and O(N) to find edge
        Approach:
            1. call dfs_cycle..
            2. store at which node cycle start
            3. now, we need to store all the node INSIDE cycle, say in result[]
            4. while storing all node INSIDE cycle
            5. if again find node from WHERE cycle start.
            6. we STOP
            7. return the max idx of result with edges

        OPTIMZIE TC - O(N), with UNION-FIND(disjoint-set) ... need to read it.
        """
        n = len(edges)
        graph = {v: [] for v in range(1, n + 1)}

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = set()

        result = set()

        def find_last_idx(u, v):  # O(N)
            # find index of combo u,v exist edges
            idx = -1
            if [u, v] in edges:
                idx = edges.index([u, v])
            elif [v, u] in edges:
                idx = edges.index([v, u])
            return idx

        cycle_at = -1

        def dfs_detect_cycle_w_parent(source, parent):  # O(N^2)
            nonlocal cycle_at
            visited.add(source)

            for child in graph[source]:  # O(N)
                if child not in visited:
                    if dfs_detect_cycle_w_parent(child, source):
                        if cycle_at == source:
                            # while poping node in cycles,
                            # if again find node from where cycle start
                            # then STOP poping
                            cycle_at = -1
                            return True
                        if cycle_at != -1:
                            idx_in_edge = find_last_idx(source, child)  # O(N)
                            result.add(idx_in_edge)

                        return True
                elif child != parent:
                    if cycle_at == -1:  # store which node cause cycle
                        cycle_at = child
                        idx_in_edge = find_last_idx(source, child)
                        result.add(idx_in_edge)
                    return True
            return False

        dfs_detect_cycle_w_parent(1, -1)  # O(N^2)

        # so, final TC - O(N^2)

        max_idx = max(list(result))
        return edges[max_idx]
