""" Problem: [https://leetcode.com/problems/surrounded-regions/]
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    Explanation: Notice that an 'O' should not be flipped if:
    - It is on the border, or
    - It is adjacent to an 'O' that should not be flipped.
    The bottom 'O' is on the border, so it is not flipped.
    The other three 'O' form a surrounded region, so they are flipped.
"""


class Solution:
    def solve(self, grid: List[List[str]]) -> None:
        """
        TC - O(N*M)
                - O(N) + O(M) + O(N+M)*O(V+E) + O(N*M) => O(N*M)

        Approach:
            1. store all boundry with O in set
            2. call DFS for all (r,c) of set
            3. now store all the connected element with 'O' in new set
            4. run N*M for-loop and all those not in new set -> flip to 'X'

        Do not return anything, modify board in-place instead.
        """
        N = len(grid)
        M = len(grid[0])

        visited = set()

        def is_safe(r, c):
            return 0 <= r < N and 0 <= c < M and grid[r][c] == "O"

        def dfs(r, c):
            directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

            if not is_safe(r, c):
                return

            if (r, c) in visited:
                return

            visited.add((r, c))

            for rr, cc in directions:
                nr = r + rr
                nc = c + cc
                if (nr, nc) not in visited:
                    dfs(nr, nc)

        border_o = set()
        for idx, row in enumerate(grid):  # O(N)
            if grid[idx][0] == "O":
                border_o.add((idx, 0))
            if grid[idx][M - 1] == "O":
                border_o.add((idx, M - 1))

        for idx, col in enumerate(grid[0]):  # O(M)
            if grid[0][idx] == "O":
                border_o.add((0, idx))
            if grid[N - 1][idx] == "O":
                border_o.add((N - 1, idx))

        for r, c in list(border_o):  # O(N+M)
            dfs(r, c)  # O(V+E)

        for idx, row in enumerate(grid):  # O(N*M)
            for jdx, col in enumerate(grid[0]):
                if (idx, jdx) not in visited:
                    grid[idx][jdx] = "X"

        # Total Time Complexity
        # O(N) + O(M) + O(N+M)*O(V+E) + O(N*M)
        # O(N*M)
