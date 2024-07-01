def optimize(arr):
    """ Make a variable - largest
    and compare each value with largest
    TC - O(N)    
    """
    largest = float("-inf")
    for val in arr:
        largest = max(val, largest)
    return largest


def brute_force(arr):
    """TC - O(NLogN)"""
    arr.sort()
    return arr[-1]


arr = [3, 2, 1, 5, 2]

print(brute_force(arr))
print(optimize(arr))
