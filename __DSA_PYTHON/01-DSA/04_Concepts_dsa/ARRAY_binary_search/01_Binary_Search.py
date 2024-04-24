def binary_search(array, target):
    start, end = 0, len(array) - 1

    print("Subarray Length: ", end="")
    while start <= end:
        print(end - start, end=" -> ")
        mid = start + ((end - start) // 2)

        if array[mid] == target:
            print()
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    print()
    return -1


sorted_array = sorted(range(1, 255))
target = 7

result = binary_search(sorted_array, target)
print(f"Result: array[{result}] = {sorted_array[result]}")
