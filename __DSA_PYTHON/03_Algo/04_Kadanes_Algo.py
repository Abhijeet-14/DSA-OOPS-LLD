"""The Kadane's algorithm is used to find the maximum subarray sum in a given array."""


def kadane_algo(nums):
    max_sum = nums[0]
    max_curr = nums[0]

    for num in nums[1:]:
        max_curr = max(max_curr + num, num)
        max_sum = max(max_sum, max_curr)

    print(max_sum)


nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
kadane_algo(nums)
