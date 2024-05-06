""" Problem: [https://leetcode.com/problems/jump-game/]
"""


def canJump(nums: list[int]) -> bool:
    """
    TC - O(N)
    SC - O(1)
    Approach:
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
