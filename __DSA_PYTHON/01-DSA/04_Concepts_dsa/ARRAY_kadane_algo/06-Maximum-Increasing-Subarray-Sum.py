""" Problem: EASY-[https://leetcode.com/problems/maximum-ascending-subarray-sum/]
"""


class Solution:
    def maxAscendingSum(self, nums: list[int]) -> int:
        """
        Approach
            - Kadane Algo
                - generlly -- if curr_sum < 0 -- break sub-Array -- curr_sum = 0
            - so here -
                - non-increasing (nums[i] <= prev) -- break sub-Array -- curr_sum = 0
        """
        N = len(nums)

        ms = float("-inf")  # max_sum
        cs = 0  # curr_sum

        prev = nums[0]
        for i in range(N):

            if i > 0 and nums[i] <= prev:  # break sub-Array
                cs = 0

            prev = nums[i]

            cs += nums[i]

            ms = max(ms, cs)
        return ms
