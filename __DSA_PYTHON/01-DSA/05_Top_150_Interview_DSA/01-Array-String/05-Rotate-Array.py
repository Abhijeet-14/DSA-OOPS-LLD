""" Problem: [https://leetcode.com/problems/rotate-array/description/]
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        N = len(nums)

        # Edge case
        if k == 0 or N == 0:
            return

        if k > N:
            k = k % N

        for _ in range(N - k):
            nums.append(_)

        jdx = 0
        for idx in range(N - k):
            nums[N + jdx] = nums[idx]
            jdx += 1
        for _ in range(N - k):
            nums.pop(0)
