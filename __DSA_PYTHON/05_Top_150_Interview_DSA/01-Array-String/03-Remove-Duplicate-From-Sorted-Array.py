""" Problem: [https://leetcode.com/problems/remove-duplicates-from-sorted-array/]
need to solve in IN-PLACE
"""
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        N = len(nums)
        if N <1: return nums

        # sorted - no need of set -- use prev
        prev = nums[0]
        l, r = 1, 1
        while r<N:
            
            if nums[r] != prev:
                prev = nums[r]
                nums[l] = nums[r]
                l+=1
            r+=1
        
        return l
