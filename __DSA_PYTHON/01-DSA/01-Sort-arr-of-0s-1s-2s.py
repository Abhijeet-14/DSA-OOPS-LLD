arr = [0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1]


def solve_bf(arr):
    """
    TC - O(NLogN)
    """
    arr.sort()
    print(arr)


def solve_better(arr):
    """
    TC - O(2N)
    """
    zero = 0
    one = 0
    two = 0
    for v in arr:
        if v == 0:
            zero += 1
        elif v == 1:
            one += 1
        elif v == 2:
            two += 1

    for i in range(len(arr)):
        if zero != 0:
            arr[i] = 0
            zero -= 1
        elif one != 0:
            arr[i] = 1
            one -= 1
        elif two != 0:
            arr[i] = 2
            two -= 1
    print(arr)


# solve_bf(arr)
# solve_better(arr)


def solve_dutch_notion_algo_optimize(arr):
    """
    TC - O(N)
    SC - O(1)

    g1: 0 -> low => 0's
    g2: low+1 => mid-1 => 1's
    g3: high+1 => N => 2's
    g4: only --> mid --> high is unsorted => sort it
    """

    N = len(arr)
    l = 0
    h = N-1
    m = 0
    while l < N and m < N and h >= 0 and m <= h:
        if arr[m] == 0:
            # g1
            arr[l], arr[m] = arr[m], arr[l]
            l += 1
            m += 1
        elif arr[m] == 1:
            # nothing
            m += 1
        elif arr[m] == 2:
            arr[m], arr[h] = arr[h], arr[m]
            h -= 1
    print(arr)


solve_dutch_notion_algo_optimize(arr)
