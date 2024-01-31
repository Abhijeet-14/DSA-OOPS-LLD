import heapq


def heapify(arr, i):
    N = len(arr)
    largest = i

    # left-child_idx formula using current index(i) = 2*i+1
    left_child_idx = 2 * i + 1
    # right-child_idx formula using current index(i) = 2*i+2
    right_child_idx = 2 * i + 2

    if left_child_idx < N and arr[largest] < arr[left_child_idx]:
        largest = left_child_idx
    if right_child_idx < N and arr[largest] < arr[right_child_idx]:
        largest = right_child_idx

    if largest != i:
        # swap with largest
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, largest)


def heap_sort(arr):
    N = len(arr)

    # Build Max-Heap
    for i in range(N // 2 - 1, -1, -1):
        heapify(arr, i)

    new_arr = []
    for i in range(N - 1, -1, -1):
        new_arr.append(arr.pop(0))
        heapify(arr, 0)

    return new_arr


heap = [12, 11, 13, 5, 6, 7]
print("Original Array:")
print(heap)

sorted_arr = heap_sort(heap)
print("TC - O(N*logN)")

print("\nArray after Heap Sort:")
print(sorted_arr)
print(list(reversed(sorted_arr)))
