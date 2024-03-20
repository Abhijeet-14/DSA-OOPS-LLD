""" Problem: [https://leetcode.com/problems/word-search/]
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true
"""


class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        """
        TC - O(N*M)*O(4^L), L is target word
        Approach:
        1. match word index by index with currect (r,c)
        2. we need to run from each (r,c) of board and check word exists or not -> N*M for-loop -> dfs
        3. in dfs once (r,c) is safe -> check word match -> return True
        4. if no match, add (r,c) in visited -> call its neighbor -> if word not found -> remove (r,c) in visited
        4. if found return True
        """
        N = len(board)
        M = len(board[0])

        visited = set()

        # approach 1 -  dfs or backtrack
        def is_safe(r, c, word_idx):
            return (
                0 <= r < N
                and 0 <= c < M
                and word[word_idx] == board[r][c]
                and (r, c) not in visited
            )

        def dfs(rw, cl, word_idx):
            directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

            if is_safe(rw, cl, word_idx):
                if word_idx == len(word) - 1:  # exact word match
                    return True

                visited.add((rw, cl))

                for r, c in directions:
                    nr = rw + r
                    nc = cl + c
                    if (nr, nc) not in visited and dfs(nr, nc, word_idx + 1):
                        return True

                visited.remove((rw, cl))  # backtrack

            return False

        for idx, row in enumerate(
            board
        ):  # O(N) => O(N*M)*O(E^L) =>O(N*M) * O(4^L), L = target word
            for jdx, col in enumerate(row):  # O(M)
                if board[idx][jdx] == word[0] and dfs(
                    idx, jdx, 0
                ):  # O(E^L), as backtrack - not proper dfs - see visited.remove(...)
                    return True
                visited = set()

        return False
