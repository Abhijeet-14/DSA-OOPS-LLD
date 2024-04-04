""" Problem: [https://leetcode.com/problems/merge-sorted-array/]
"""
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        if n == 0:
            return 
        if m == 0:
            for idx, val in enumerate(nums2): 
                nums1[idx] = val
            return 

        i = 0
        j = 0
        idx = 0

        # add m more zeros
        for _ in range(m):
            nums1.append(0)

        while i < m and j < n:
            if nums1[i] < nums2[j]:
                nums1[m + idx] = nums1[i]
                i += 1
            else:
                nums1[m + idx] = nums2[j]
                j += 1
            idx += 1

        while i < m:

            nums1[m + idx] = nums1[i]
            i += 1
            idx += 1
        while j < n:
            nums1[m + idx] = nums2[j]
            j += 1
            idx += 1

        # remove first 'm' element 
        for _ in range(m):
            nums1.pop(0)
