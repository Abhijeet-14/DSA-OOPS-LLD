def two_pointer_sum(arr, target):
    left = 0
    right = len(arr) - 1
    while left < right:
        curr_sum = arr[left] + arr[right]
        if curr_sum == target:
            return left, right
        elif curr_sum > target:
            right -= 1
        else:
            left += 1

    return None


sorted_array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
target_sum = 7

result_pair = two_pointer_sum(sorted_array, target_sum)

print(result_pair)
