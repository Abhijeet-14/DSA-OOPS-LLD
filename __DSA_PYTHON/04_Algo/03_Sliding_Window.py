def sliding_window_max_sum_subarray(nums, k):
    N = len(nums)
    if k < 0 and N < 0:
        return 0

    max_sum = sum(nums[:k])  # k-element
    current_sum = max_sum
    for idx in range(k, N):
        current_sum +=  -nums[idx - k] + nums[idx]
        # pop kth-element + append curr idx
        max_sum = max(max_sum, current_sum)

    return max_sum


nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
result = sliding_window_max_sum_subarray(nums, k)
print("L6:", result)
