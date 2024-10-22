result = []
def solve(n, arr, target, res, prev):
    if target == 0:
        result.append([v for v in res])
        return
    
    if n<0 or target<0:
        return
    
    # Jump Duplicate
    if arr[n] == prev:
        return
    
    res.append(arr[n])
    solve(n-1, arr, target-arr[n], res, arr[n])

    res.remove(arr[n])
    solve(n-1, arr, target, res, prev)

    # prev=  -1

    # for i in range(n, len(arr)):
    #     # jump duplicate
    #     if arr[i] == prev:
    #         continue

    #     res.append(arr[i])
    #     solve(i+1, target-arr[i], res)
    #     res.pop()

    #     prev = arr[n]



arr = [10,1,2,7,6,1]
target  = 8
solve(len(arr)-1,arr,target, [], -1)

print(result)