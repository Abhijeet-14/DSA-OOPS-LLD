""" Problem: [https://leetcode.com/problems/candy/]
"""


class Solution:
    def candy(self, ratings: list[int]) -> int:
        """
        TC - O(2*N)
        Approach:
            - 2 loop
            - 1st - from left -> right, compare ONLY left padosi
            - 2nd - from right -> left, compare ONLY right padosi
        Main Concept:
            - 2 loop -> Left->Right & Right->Left
        """

        # 2 Condition
        # 1 - all kid -- atlease 1 candy
        # kid - higher rating to neighbor -- have higher candy respectivey
        N = len(ratings)

        # condition_1 -- done
        candy = [1] * N

        # condition_2 -- left -> N
        # only compare Left Padosi
        for i in range(1, N):
            # Val > left
            if ratings[i] > ratings[i - 1]:
                candy[i] = candy[i - 1] + 1

        # condition_2 -- N -> right
        # only compare Right Padosi
        for i in range(N - 2, -1, -1):
            # val > right
            if ratings[i] > ratings[i + 1]:
                candy[i] = max(candy[i], candy[i + 1] + 1)

        return sum(candy)


arr = [1, 3, 4, 5, 2]
arr = [1, 2, 87, 87, 87, 2, 1]
res = Solution().candy(arr)
print(res)
