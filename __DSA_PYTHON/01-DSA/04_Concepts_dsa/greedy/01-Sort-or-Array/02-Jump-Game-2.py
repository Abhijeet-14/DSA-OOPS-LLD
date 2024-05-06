""" Problem: [https://leetcode.com/problems/jump-game-ii/description/]
"""


class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        TC - O(N)
        SC - O(1)
        Approach:
            - at i - find max in window [i, i+nums[i]]
            - count++
            - goto next window: [r+1, max_found]
        """
        l, r = 0, 0
        count = 0
        while r < len(nums) - 1:  # reach end?
            max_reach_at_L = 0  # max can travel in window [i, i+nums[i]] index
            for i in range(l, r + 1):  # window [i, i+nums[i]]
                max_reach_at_L = max(i + nums[i], max_reach_at_L)

            l = r + 1  # jump to next window
            r = max_reach_at_L
            count += 1

        return count
