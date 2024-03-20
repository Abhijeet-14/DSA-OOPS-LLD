""" Problem : [https://leetcode.com/problems/network-delay-time/description/]
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
"""


class Solution:
    class Pair:
        def __init__(self, to, w):
            self.to = to
            self.w = w

        def __lt__(self, other):
            return self.w < other.w

    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        """
        TC - O(VlogV + E)
        Approach:
            1. we need -> Return the minimum time it takes for all the n nodes to receive the signal
            2. min mean last node at farthest distance -> should reach definitely.
            3. so -> Apply dijkstra(K) -> and find MAX(!=inf) distance.

        """
        graph = {}
        distance = [float("inf")] * (n)

        def build_graph():
            """O(V+E)"""
            for u, v, w in times:
                pair = self.Pair(v, w)
                if u not in graph:
                    graph[u] = []
                graph[u].append(pair)

        build_graph()  # O(V+E)

        def dijkstra(source):
            """
            TC - O(V*logV + E)
            """
            import heapq

            heap = []
            heapq.heappush(heap, self.Pair(source, 0))
            distance[source - 1] = 0
            while len(heap) > 0:  # O(V)
                curr_pair = heapq.heappop(heap)  # O(logV)
                curr_to, curr_w = curr_pair.to, curr_pair.w

                for ch in graph.get(curr_to, []):  # O(E)
                    if distance[curr_to - 1] + ch.w < distance[ch.to - 1]:
                        distance[ch.to - 1] = distance[curr_to - 1] + ch.w
                        heapq.heappush(
                            heap, self.Pair(ch.to, distance[ch.to - 1])
                        )  # O(logV)

        dijkstra(k)  # O(VlogV + E)

        mx = -1
        for val in distance:
            if val == float("inf"):
                return -1
            mx = max(mx, val)

        return mx