result = []

def solve(n, arr, res):
    """
    TC - O(2^N)
    In all subsequence -- 2 option
    - take or Not-take
    """
    global result

    if n<0:
        result.append([v for v in res])
        return
    
    # take
    res.append(arr[n])
    solve(n-1, arr, res)

    res.remove(arr[n])
    solve(n-1, arr, res)

arr = [3,1,2]

solve(len(arr)-1, arr, [])
print(result)