""" Problem: [https://leetcode.com/problems/jump-game/]
"""


def canJump(nums: list[int]) -> bool:
    """
    TC - O(N)
    SC - O(1)
    Approach:
        - In view of the fact that
            - we can reach the end in any case, it works iteratively.
            - It's Greedy
        - curr_posi - has crossed max_reach, if started 0th
        - is max_reach from ith > prev_max -- update
        - is max_reach -- crossed or reach N-1?
    """
    N = len(nums)
    max_reach = 0

    for i, val in enumerate(nums):
        # Have we crossed max_reach from 0th?
        if i > max_reach:
            return False

        # max_reach from ith?
        # is > prev_max --> update
        max_reach = max(i + val, max_reach)

        # can we reach or cross end?
        if max_reach >= N - 1:
            return True


arr = [2, 3, 1, 1, 4]
arr = [3, 2, 1, 0, 4]
res = canJump(arr)
print(res)

""" Dry-Run - [2,3,1,1,4]
i > max_reach:              ==> 0>0       || 1>2
max_reach = max(i + val, m) ==> (0+2,0)=2 || 1+3>2=4
max_reach >= N - 1:         ==> 2>=4      || 4>=4 - True
"""

""" Dry-Run - [3,2,1,0,4]
i > max_reach:              ==> 0>0       || 1>3       || 2>3       || 3>3       || 4>3 - True
max_reach = max(i + val, m) ==> (0+3,0)=3 || (1+2>3)=3 || (2+1,3)=3 || (3+0,3)=3 || 
max_reach >= N - 1:         ==> 3>=4      || 3>=4      || 3>=4      || 3>=4      ||
"""


def canJump_2_BEST(nums: list[int]) -> bool:
    """
    TC - O(N)
    SC - O(1)
    Approach:
        - at each Index -- find max can jump in its window
        - window at i: [i, i + nums[i]]
        - goto next window:
        -       l = r+1, r = max of prev window
    """
    N = len(nums)
    l, r = 0, 0
    while r < N - 1 and l <= r:  # reached end? &  left < max_reach_at_L
        max_reach_at_L = 0  # window at L: [i, i+nums[i]]
        for i in range(l, r + 1):  # find max in window at L
            max_reach_at_L = max(i + nums[i], max_reach_at_L)

        l = r + 1  # jump to next window
        r = max_reach_at_L

    return r >= N - 1


res = canJump(arr)
print(res)

""" Dry Run [2,3,1,1,4]
l, r = 0, 0
while r < N - 1 and l <= r:  || 0<4 & 0<=0 || 2<4 & 1<=2 ||
    max_reach_at_L = 0 
    for i in range(l, r + 1):  || [0,1] || [1,3] ||
        max_reach_at_L = max(i + nums[i], max_reach_at_L) || (0+2,0)=2 || (1+3, 2)=4 || (2+1,4)=4||(3+1,4)=4

    l = r + 1 || 1 || 3
    r = max_reach_at_L || 2 || 4

return r >= N - 1 || 4>=4
"""
