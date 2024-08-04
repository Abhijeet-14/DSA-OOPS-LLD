""" Problem: [https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/]"""
class Solution:
    def minReorder(self, n: int, connections: list[list[int]]) -> int:
        """
        TC - O(V+E), SC - O(V)
        Approach:
            - this directed graph -- but build bi-dirrection graph
            - travel bfs and check (ch, src) in connects -- if not -- cnt++
        """

        g = {i: [] for i in range(n)}

        direction = set()
        for u, v in connections:
            direction.add((u, v))
            g[u] = g.get(u, []) + [v]
            g[v] = g.get(v, []) + [u]

        cnt = 0
       

        # # bfs
        q = deque()
        vis = set()
        vis.add(0)
        q.append(0)

        while len(q) > 0:
            par = q.pop()
            children = g[par]

            for ch in children:
                if ch not in vis:
                    # can reach par from ch - NO ? cnt++
                    if (ch, par) not in direction:
                        cnt+=1
                    vis.add(ch)
                    q.append(ch)
        return cnt
