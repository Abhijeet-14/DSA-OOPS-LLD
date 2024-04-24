class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        left, right = 0, 1
        max_benifit = 0

        N = len(prices)
        if N < 2:
            return 0
        while left <= right and left < N and right < N:
            # print(left, right, max_benifit, prices[right] >= prices[left])
            if prices[right] >= prices[left]:
                max_benifit = max(max_benifit, curr_benifit)
                curr_benifit = prices[right] - prices[left]
            else:
                left = right
            right += 1
        return max_benifit if max_benifit != float("-inf") else 0
