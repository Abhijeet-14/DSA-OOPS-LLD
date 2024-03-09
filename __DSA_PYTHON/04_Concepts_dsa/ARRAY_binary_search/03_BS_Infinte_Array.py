INFINTE = 10**7
print(INFINTE)
array = sorted(range(0, INFINTE, 5))


def binary_search_at_infinte_sorted_array(arr, target):
    start = 0
    # Assume end = 1, as we don't what will be the length of array
    end = 1

    # check the max value of end
    is_end = True
    count = 0
    while is_end:
        count += 1
        try:
            if arr[end] < target and arr[end * 2]:
                start = end
                end = end * 2
            else:
                is_end = False
        except Exception as e:
            is_end = False
            continue
    print("Loops to get end: ", count)

    count = 0
    print("Sub-Array Length: ", end="")
    while start <= end:
        count += 1
        print(end - start, end="-> ")

        mid = start + ((end - start) // 2)

        if arr[mid] == target:
            print()
            return mid
        elif arr[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    print("\nLoops to search: ", count)
    return -1


target = 5242860

result = binary_search_at_infinte_sorted_array(array, target)
print("Result Index: ", result, array[result])
