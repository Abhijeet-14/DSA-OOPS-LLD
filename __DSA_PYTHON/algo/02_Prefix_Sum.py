# =========================
#       ALGORITHM
# =========================
print("\n---ALGORITHM CONCEPTS---")


def calculate_prefix_sum(nums):
    N = len(nums)
    if N < 1:
        return nums

    prefix_sum = [0] * (N)
    prefix_sum[0] = nums[0]

    for idx in range(1, N):
        prefix_sum[idx] = prefix_sum[idx - 1] + nums[idx]

    return prefix_sum


# nums = [1, 2, 3, 4, 5]
nums = [10, 20, 10, 5, 15]
prefix_sum_result = calculate_prefix_sum(nums)

print(prefix_sum_result)
print("TC - O(N), AS - O(N)", end="\n\n")


def calculate_suffix_sum(nums):
    N = len(nums)
    suffix_sum = [0] * (N)
    suffix_sum[N - 1] = nums[N - 1]

    for idx in range(1, N):
        suffix_sum[N - 1 - idx] = suffix_sum[N - idx] + nums[N - 1 - idx]

    return suffix_sum


nums = [1, 2, 3, 4, 5]
suffix_sum_result = calculate_suffix_sum(nums)

print(suffix_sum_result)
print("TC - O(N), AS - O(N)", end="\n\n")


# =========================
#       QUESTION
# =========================
print("\n---QUESTIONS---")
"""Given an array arr[] of size N. Given Q queries and in each query given L and R, Print the sum of array elements from index L to R."""
nums = [3, 6, 2, 8, 9, 2]
prefix_sum_result = calculate_prefix_sum(nums)

queries = [[2, 3], [4, 6], [1, 5], [3, 6]]
for query in queries:
    L = query[0] - 1
    R = query[1] - 1

    if L > 0:
        sub_array_sum = prefix_sum_result[R] - prefix_sum_result[L - 1]
    else:
        sub_array_sum = prefix_sum_result[R]

    print(sub_array_sum, end=", ")

print("\nTC - O(N), AS - O(N)", end="\n\n")
