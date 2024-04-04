""" Problem: [https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/]
IN-Place needed
"""


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        N = len(nums)
        if N < 1:
            return nums

        # sorted - no need of set -- use prev
        prev = nums[0]

        # keep count of duplicate
        count = 1
        l, r = 1, 1

        while r < N:
            if nums[r] == prev and count < 2:
                # if MATCH
                nums[l] = nums[r]
                l += 1

                count += 1
            elif nums[r] != prev:
                # if NOT match
                prev = nums[r]
                nums[l] = nums[r]
                l += 1
                count = 1
            else:
                count += 1

            r += 1

        return l
