def binary_search(arr, target):
    left = 0
    right = len(arr) - 1
    while left < right:
        mid = left + (right - left) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            right -= 1
        else:
            left += 1
    return -1


arr = [1, 2, 3, 4, 5, 6]
target = 5
result = binary_search(arr, target)
print("TC - O(logN) ", result)
