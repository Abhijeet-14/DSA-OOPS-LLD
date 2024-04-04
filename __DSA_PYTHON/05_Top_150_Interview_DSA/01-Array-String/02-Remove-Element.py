""" Problem: [https://leetcode.com/problems/remove-element/description/]
need to solve in IN-Place
"""

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        """ 
        TC - O(N)
        AS - O(1)
        Approach:
            - if re-arrange -> n-rearrage -> hence O(N^2)
            - use 2-pointer
            - l, r = 0, and increase r in every time till < N
            - and if curr != val -> assign R element to L index
            - and increasse L by 1
        Example:
        arr: [0 1 2 2 3 0 4 2]
        l, r, arr
        0, 0, [0 
        1, 1, [0, 1
        2, 2, [0, 1, 
        2, 3, [0, 1, 
        2, 4, [0, 1, 3
        3, 5, [0, 1, 3, 0
        4, 6, [0, 1, 3, 0, 4
        5, 7, [0, 1, 3, 0, 4
        6, 8
        """
        left, right = 0, 0

        while right < len(nums):
            if nums[right] != val:
                nums[left] = nums[right]
                left += 1

            right += 1

        return left