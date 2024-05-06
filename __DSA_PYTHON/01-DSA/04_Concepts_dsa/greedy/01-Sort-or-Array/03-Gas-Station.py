""" Problem: [https://leetcode.com/problems/gas-station/]
"""


def can_complete_circuit_O_N(gas: list[int], cost: list[int]) -> int:
    """
    TC: O(N)
    SC: O(N)
    Approach:
        - tank -- if tank <=0, need to re-start  =>  so start = i+1
        - we know, sum(gas)>=sum(cost) -- then SUCCESS
        - ex - 12L >= 10L -- SUCCESS, else 9L >= 12L -- FAIL
        - so if we start at 'i' and reach to 'N' -->
        - then, sum(gas[0:i-1]) -  sum(cost[0:i-1]) + tank >= 0 -- then success --
        - able to reach 'i' circularlly.
    Main Concept:
        - at i, sum_of_total_gas[i-1] + tank_gas - total_travel_cost[i-1] >= 0
            - tank + sum(gas[0:i-1]) - sum(cost[0:i-1])
    """
    N = len(gas)
    if sum(gas) < sum(cost):
        # bcoz - if 10 L petrol, but need 11 L to A->B -- never reach B
        return -1

    tank = 0
    start = 0
    for i, val in enumerate(gas):
        tank = tank + gas[i] - cost[i]

        # re-start if tank -ve
        if tank <= 0:
            tank = 0
            start = (i + 1) % N

    # we know, sum(gas) >= sum(cost) -- then cirular
    # so, at start,
    # tank + sum(gas[0:start-1]) - sum(cost[0:start-1]) >= 0 --> SUCCESS
    if tank + sum(gas[0 : start - 1]) - sum(cost[0 : start - 1]) >= 0:
        return start
    else:
        return -1


gas = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]
res = can_complete_circuit_O_N(gas, cost)
print(res)


def can_complete_circuit_O_N_Square(gas: list[int], cost: list[int]) -> int:
    """
    TC - O(N^2)
        - 0 -> N
        - 1 -> N -> 0
        - 2 -> N -> 1 .. O(N^2)
    """
    if sum(gas) < sum(cost):
        return -1

    N = len(gas)
    tank = 0
    start = 0
    i = 0

    while i < N:
        tank = tank + gas[i] - cost[i]

        i = (i + 1) % N
        if i == start:
            return start

        if tank <= 0:
            tank = 0
            start += 1
            i = start

    return -1


# res = can_complete_circuit_O_N(gas, cost)
# print(res)
