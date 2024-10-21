def optimize(arr):
    """
    1. travel from 0 -> n
    2. 2 variable, first_large & sec_large
    3. if curr > first_large --> that mean
        sec_large = first_large
        first_large = curr

    TC - O(N)
    """
    first_large = float("-inf")
    sec_large = float("-inf")

    for val in arr:
        if val > first_large:
            sec_large = first_large
            first_large = val
    return sec_large


def brute_force(arr):
    """
    1. Sort array
    2. n-1 is First largest
    3. so travel from n-2 place --
    3. find 2nd largest

    TC - O(NLogN)
    """
    arr.sort()
    first_large = arr[-1]
    sec_large = float("-inf")
    for i in range(len(arr) - 2, -1, -1):
        val = arr[i]
        if val != first_large:
            sec_large = max(val, sec_large)
    return sec_large


arr = [5, 2, 4, 7, 4, 7, 1]
print("brute_force TC: ", brute_force(arr))
print("optimize TC: ", optimize(arr))
