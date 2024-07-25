"""leetcode: [https://leetcode.com/problems/max-number-of-k-sum-pairs]"""


def maxOperations(arr: list[int], k: int) -> int:
    i = 0
    j = len(arr) - 1
    if len(arr) < 2:
        return sum(arr) == k

    arr.sort()
    cnt = 0
    while i < j:
        curr_sum = arr[i] + arr[j]
        if curr_sum == k:
            cnt += 1
            i += 1
            j -= 1
        elif curr_sum > k:
            j -= 1
        else:
            i += 1
    return cnt


nums = [1, 2, 3, 4]
k = 5

print(maxOperations(nums, k))

