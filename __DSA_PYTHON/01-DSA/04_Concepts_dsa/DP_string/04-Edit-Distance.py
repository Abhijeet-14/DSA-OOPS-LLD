"""Leetcode: [https://leetcode.com/problems/edit-distance/]"""


class Solution:

    def minDistance(self, word1: str, word2: str) -> int:
        """
        TC - O(N*M)
        SC - O(N*M)
        Approach:
            - if match - i-1, j-1 -- 0 operation
            - if not match find min of (insert, delete, replace) -- 1 operation
            - Base Case:
                - word1 empty -- then insert all the word2
                - word2 empty -- then delete all the word1
        """
        dp = {}

        def solve(i, j):
            # base case 1: "" "abc" - insert "abc"
            if i < 0:
                return j + 1  # insert

            # base case 2: "abc" "" - delete "abc"
            if j < 0:
                return i + 1  # delete

            key = (i, j)
            if key in dp.keys():
                return dp[key]

            # match case: i-1, j-1
            if word1[i] == word2[j]:
                dp[key] = 0 + solve(i - 1, j - 1)  # 0-operation needed

            else:
                dp[key] = 1 + min(
                    solve(i, j - 1),  # insert - i,j-1
                    solve(i - 1, j),  # delete - i-1, j
                    solve(i - 1, j - 1),  # replace - i-1, j-1
                )
            return dp[key]

        N = len(word1)
        M = len(word2)
        res = solve(N - 1, M - 1)
        return res if res != float("inf") else 0

word1="horse" 
word2="ros"
print(Solution().minDistance(word1, word2))