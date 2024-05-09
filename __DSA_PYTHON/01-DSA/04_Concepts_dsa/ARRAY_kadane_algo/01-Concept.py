"""
Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within a arr[] with the largest sum. 
"""

"""
Approach:
    - curr_sum, max_sum at i-index
    - if curr_sum < 0:
        - means -- sum[:i-1] > sum[:i] 
        - so do-not use A[i] -- break in sub-array
        - re-start of new sub_array -- curr_sum = 0
"""


def kadane_algo(arr):

    curr_sum = 0
    max_sum = float("-inf")

    for val in arr:
        curr_sum += val

        if curr_sum > max_sum:
            max_sum = curr_sum

        if curr_sum < 0:  # sum[:i-1] > sum[:i] -- don't use A[i] -- break sub-array
            curr_sum = 0  # for new-SubArray

    return max_sum


def kadane_algo_print_sub_array(arr):

    curr_sum = 0
    max_sum = float("-inf")

    # store window
    left = 0
    right = 0
    for i, val in enumerate(arr):
        curr_sum += val

        if curr_sum > max_sum:
            max_sum = curr_sum
            right = i  # store end of window

        if curr_sum < 0:  # sum[:i-1] > sum[:i] -- don't use A[i] -- break sub-array
            left = i + 1  # new subArray -- start at i + 1
            curr_sum = 0  # for new-SubArray

    print(arr[left : right + 1])


arr = [-2, -3, 4, -1, -2, 1, 5, -3]

res = kadane_algo(arr)
print(res)
kadane_algo_print_sub_array(arr)
