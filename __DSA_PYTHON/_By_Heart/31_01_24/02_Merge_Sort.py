def merge_sort(arr):
    divide_2_arr(arr)


def merge_2_arr(left_arr, right_arr, arr):
    N = len(arr)
    n = len(left_arr)
    m = len(right_arr)

    i = 0
    j = 0
    k = 0
    while i < n and j < m:
        if left_arr[i] < right_arr[j]:
            arr[k] = left_arr[i]
            i += 1
        else:
            arr[k] = right_arr[j]
            j += 1
        k += 1

    while i < n:
        arr[k] = left_arr[i]
        i += 1
        k += 1
    while j < m:
        arr[k] = right_arr[j]
        j += 1
        k += 1


def divide_2_arr(arr):
    N = len(arr)
    if N < 2:
        return

    left_arr = arr[0 : N // 2]
    right_arr = arr[N // 2 : N]

    divide_2_arr(left_arr)
    divide_2_arr(right_arr)

    merge_2_arr(left_arr, right_arr, arr)


arr = [5, 9, 3, 6, 2, 8, 4, 10, 1]

merge_sort(arr)

print(arr)
