"""
no of possible:
input - 9
coins_available = [1,2,5,10]
op - 1, 
{1},{1,2} , {1,5} , {2,5},{1,2,5}
"""


def solve(coins_available, target, current_coin_index, result, current_coin_group):
    if current_coin_index < 0:
        return 0

    if target == 0:
        result.append(current_coin_group)
        return 1

    set_2 = current_coin_group
    if coins_available[current_coin_index] <= target:
        set_1 = current_coin_group
        if not isinstance(set_1, set):
            set_1 = set()

        set_1.add(coins_available[current_coin_index])
        # print(25, set_1, coins_available[current_coin_index], target)

        return max(
            solve(
                coins_available,
                target - coins_available[current_coin_index],
                current_coin_index,
                result,
                set_1,
            ),
            solve(coins_available, target, current_coin_index - 1, result, set_2),
        )

    return solve(coins_available, target, current_coin_index - 1, result, set())


# print("Enter target value")
target = int(input())
coins_available = [1, 2, 5, 10]
current_coin_index = len(coins_available) - 1

result = []
current_coin_group = set()
all_posible_set = solve(
    coins_available, target, current_coin_index, result, current_coin_group
)
print(result)
