# arr = [8, 9, 10, 12, 15, 18, 20, 1, 3, 5, 6, 7, 9, 11, 14, 16, 17, 19, 20, 21]
arr = [5, 6, 7, 8, 9, 10, 1, 2, 3]
# arr = [5, 6, 7, 8, 9, 10]
# arr = [10, 6, 7, 8, 9]


def binary_search(arr, target, start, end):
    while start <= end:
        mid = (end + start) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return -1


def find_peek(arr):
    N = len(arr)
    start = 0
    end = N - 1

    while start <= end:
        peek = (end + start) // 2
        peek_minus_one = (peek - 1 + N) % N
        peek_plus_one = (peek + 1) % N
        if arr[peek] >= arr[peek_minus_one] and arr[peek] >= arr[peek_plus_one]:
            return peek
        elif arr[peek] > arr[end]:
            start = peek + 1
        else:
            end = peek - 1

    return -1


peek = find_peek(arr)
print("Peek at: ", peek)
target = 9

result_left = binary_search(arr, target, 0, peek)
result_right = binary_search(arr, target, peek + 1, len(arr) - 1)

if result_left == -1 and result_right == -1:
    print("Target does not exist")
elif result_left != -1:
    print("Target exist at left subarray: ", result_left)
else:
    print("Target exist at right subarray: ", result_right)
