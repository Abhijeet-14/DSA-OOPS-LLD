""" Problem: [https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/]
"""


class Solution:
    def maximizeSum(self, nums: list[int], k: int) -> int:
        """
        TC - O(N)
        SC - O(1)
        Approach:
            S1 - to max sum -- need to max element of array
            S2 - sort arr -> max of arr each time will at -- [0] index
            S3 - sum += 0th  and [0th] = [0th]+1
        Al Sol:
        TradeOff:
        Spot Pattern: Greedy(sort, initalize, loop)
        """
        nums = sorted(nums, reverse=True)
        sum = 0
        while k > 0:
            sum += nums[0]
            nums[0] = nums[0] + 1
            k -= 1
        return sum


res = Solution().maximizeSum([1, 2, 3, 4, 5], 3)
print(res)
