result = []


def solve(n, arr, target, res):
    global result
    if target == 0:
        result.append([v for v in res])
        return

    if target < 0 or n < 0:
        return

    # take
    res.append(arr[n])
    solve(n - 1, arr, target - arr[n], res)

    # not take
    res.remove(arr[n])
    solve(n - 1, arr, target, res)


arr = [1, 2, 1]
target = 2

solve(len(arr) - 1, arr, target, [])
print(result)
