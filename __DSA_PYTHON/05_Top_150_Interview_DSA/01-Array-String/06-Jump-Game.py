""" Problem: [https://leetcode.com/problems/jump-game/]
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        N = len(nums)

        curr_max = 0
        for i, val in enumerate(nums):
            
            if i<=curr_max:
                curr_max = max(curr_max, i+val)

        return curr_max >= N-1
