""" Problem: [https://leetcode.com/problems/island-perimeter/description/]
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:
    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    Output: 16
    Explanation: The perimeter is the 16 yellow stripes in the image above.
"""


class Solution:
    def islandPerimeter(self, grid: list[list[int]]) -> int:
        """
        TC - O(N*M)
                - O(V+E)[called only 1-time] + O(N*M) -> O(V) + O(N*M) -> O(N*M)
        Approach:
        1. there only one island
        2. from a land -> to all no-land -> is our perimeter
        3. so -- is safe -> False -> 1 perimeter
        """
        N = len(grid)
        M = len(grid[0])
        visited = set()

        def is_safe(r, c):
            return 0 <= r < N and 0 <= c < M and grid[r][c] == 1

        def dfs(r, c):  # O(V+E) -> O(V+4) -> O(V)
            directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

            if not is_safe(r, c):
                return 1

            if (r, c) in visited:
                return 0

            visited.add((r, c))
            prim = 0
            for rr, cc in directions:
                nr = r + rr
                nc = c + cc
                if (nr, nc) not in visited:
                    prim += dfs(nr, nc)

            return prim

        for idx, row in enumerate(grid):
            for jdx, col in enumerate(row):
                if grid[idx][jdx] == 1:
                    # as its is sure there only 1 - so we call dfs only 1 time  - O(V+E) - O(V)
                    return dfs(idx, jdx)  # O(V)
        return 0
