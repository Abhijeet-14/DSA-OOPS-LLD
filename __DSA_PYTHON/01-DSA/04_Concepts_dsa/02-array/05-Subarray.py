def solve(arr):
    N = len(arr)
    result = 0
    left = 0
    map = {0: 0, 1: 0}
    for right in range(N):
        curr = arr[right]
        map[curr] += 1

        print(right, left, curr, map)
        while left <= right and arr[left] == 1 and map[0] != 0 and map[1] > map[0]:
            left_element = arr[left]
            map[left_element] -= 1
            left += 1
        if map[0] == map[1]:
            result = max(result, right - left + 1)
    return result


# arr = [1, 1, 1, 1]
# arr = [1, 1, 1, 0, 1]
# arr = [1, 1, 0, 1, 0, 1]
arr = [1, 1, 1, 0, 0, 1, 0, 1]
print(solve(arr))
