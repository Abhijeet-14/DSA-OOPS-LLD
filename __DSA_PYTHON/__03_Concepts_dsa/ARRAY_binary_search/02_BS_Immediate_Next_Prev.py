def bs_immediate_next(array, target):
    start, end = 0, len(array) - 1
    result = -1

    print("Sub-Array Length: ", end - start, end=" -> ")
    while start <= end:
        print(end - start, end=" -> ")
        mid = start + ((end - start) // 2)
        if array[mid] >= target:
            end = mid - 1
            result = mid
        else:
            start = mid + 1
    print()
    return result


def bs_immediate_prev(array, target):
    start, end = 0, len(array) - 1
    result = -1

    while start <= end:
        mid = start + ((end - start) // 2)
        if array[mid] >= target:
            end = mid - 1
        else:
            start = mid + 1
            result = mid

    return result


sorted_array = sorted(range(255))
sorted_array.remove(6)
sorted_array.remove(7)
sorted_array.remove(8)

target = 7
result_next = bs_immediate_next(sorted_array, target)
print(f"Immediate next of {target}: array[{result_next}] = {sorted_array[result_next]}")

target = 9
result_prev = bs_immediate_prev(sorted_array, target)
print(f"Immediate prev of {target}: array[{result_prev}] = {sorted_array[result_prev]}")
