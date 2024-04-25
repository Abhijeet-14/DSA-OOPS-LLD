""" Problem: [https://leetcode.com/problems/first-missing-positive/]
"""
def my_soution_1(arr):
    """
    TC -O(N)
    SC -O(N)
    EdgeCase:
        - duplicate: [4,2,3,1,1]
        - out of N: [10,11,12]
    BoundryCase:
        -
    TradeOff:
        -
    AlternateSol:
        - O(1) space, with In_memory sorting
    Spot patterns
        -
    """
    uniq_vals = set()
    for val in arr:
        if val > 0 and val not in uniq_vals:
            uniq_vals.add(val)

    missing = 1
    while missing in uniq_vals:
        missing += 1
    return missing


def leetcode_sol(nums: list[int]) -> int:
    """
    TC - O(N)
    SC - O(1)

    NOT Convinced with soltuion - Explain again
    """

    # Function to swap elements in the array
    def swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]

    n = len(nums)

    # Place each positive integer i at index i-1 if possible
    for i in range(n):
        # if we have all integer at correct place, so 1<=nums[i] <=n
        while 1 <= nums[i] <= n:
            if nums[i] == nums[nums[i] - 1]:
                # correct integer - at correct index
                break
            swap(nums, i, nums[i] - 1)

    # Find the first missing positive integer
    for i in range(n):
        if nums[i] != i + 1:
            return i + 1

    # If all positive integers from 1 to n are present, return n + 1
    return n + 1


arr = [1, 2, 0]
arr = [3, 4, -1, 1]
arr = [10, 11, 12]

res = my_soution_1(arr)
print(res)