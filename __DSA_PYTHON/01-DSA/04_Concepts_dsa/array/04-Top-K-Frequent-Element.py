""" Problem[Medium]: https://leetcode.com/problems/top-k-frequent-elements/description/
"""


class Solution:
    def solution_1(self, nums: list[int], k: int) -> list[int]:
        """
            TC - O(N*K)
            SC - O(N)
            EdgeCase:
                - 
            BoundryCase:
                - 
            Approach:
                - make Hashmap - put element and its frequency
                - k-times, find max frequency element 
                - add it to result array and delete that from hashmap
            TradeOff:
                - 
            AlternateSol:
                - TC - O(N*logK)
            Spot patterns
                - 
        """

        freq = {}

        for val in nums:  # O(N)
            freq[val] = freq.get(val, 0) + 1

        res = []
        while k > 0:  # O(N*K)
            max_val = 0
            max_key = -1
            for key, val in freq.items():
                if val > max_val:
                    max_key = key
                    max_val = val

            res.append(max_key)
            del freq[max_key]
            k -= 1
        return res

    def sol_2(self, nums, k):
        """
            TC - O(N*logK)
            SC - O(N)
            EdgeCase:
                - 
            BoundryCase:
                - 
            Approach:
                - Custom Priority Queue
            TradeOff:
                - 
            AlternateSol:
                - 
            Spot patterns
                - 
        """

        class FrequencyInteger:
            def __init__(self, key, val):
                self.key = key
                self.val = val

            def __lt__(self, other):
                return self.val < other.val

        freq = {}

        for val in nums:  # O(N)
            freq[val] = freq.get(val, 0) + 1

        import heapq

        heap = []
        for key, val in freq.items():
            heapq.heappush(heap, FrequencyInteger(key, val))
            if len(heap) > k:
                heapq.heappop(heap)
        return [val.key for val in heap]
