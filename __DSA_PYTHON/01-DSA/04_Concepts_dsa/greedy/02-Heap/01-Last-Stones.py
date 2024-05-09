""" Problem: [https://leetcode.com/problems/last-stone-weight/]
"""

import heapq


class Solution:
    def lastStoneWeight(self, stones: list[int]) -> int:
        """
        TC - O(N*LogN)
        SC - O(N)
        Approach:
            - Greedy approach
            - each turn -- collide 2 heaviest stone
            - to get max at each turn -- use heap
        """
        heap = [-1 * val for val in stones]
        heapq.heapify(heap)  # logN

        while len(heap) > 1:  # O(N) -> O(NLogN)
            first_stone = heapq.heappop(heap)  # O(LogN)
            second_stone = heapq.heappop(heap)

            colision_stone = abs(first_stone - second_stone)
            heapq.heappush(heap, colision_stone * -1)
        return abs(heap[0])


arr = [2, 7, 4, 1, 8, 1]
res = Solution().lastStoneWeight(arr)
print(res)
