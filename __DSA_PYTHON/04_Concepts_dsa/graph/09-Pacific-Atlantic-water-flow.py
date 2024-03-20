class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        N = len(heights)
        M = len(heights[0])

        # add boundry, -1 for Pac & -2 for At
        heights = [[-1] * M] + heights + [[-2] * M]

        for idx, row in enumerate(heights):
            heights[idx] = [-1] + row + [-2]

        N = len(heights)
        M = len(heights[0])

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        paci = set()
        atl = set()

        def is_safe(r, c, ocean):
            if 0 <= r < N and 0 <= c < M and heights[r][c] not in [-1, -2]:
                if ocean == 0 and (r, c) not in paci:
                    return True
                elif ocean == 1 and (r, c) not in atl:
                    return True

            return False

        def dfs(row, col, ocean):
            for r, c in directions:
                nr = row + r
                nc = col + c

                if is_safe(nr, nc, ocean) and heights[nr][nc] >= heights[row][col]:
                    # print(
                    #     ocean,
                    #     row,
                    #     col,
                    #     f"{heights[nr][nc]}->{heights[row][col]}",
                    #     (row, col) not in atl,
                    # )
                    if ocean == 0:
                        paci.add((nr, nc))
                    if ocean == 1:
                        atl.add((nr, nc))

                    dfs(nr, nc, ocean)
            return True

        for idx, col in enumerate(heights[0]):
            dfs(0, idx, 0)  # 0th-row
            dfs(N - 1, idx, 1)  # Nth-row

        for idx, col in enumerate(heights):
            dfs(idx, 0, 0)  # 0th-col
            dfs(idx, M - 1, 1)  # Mth-col

   

        res = []
        

        for val in list(atl):
            if val in paci:
                res.append([val[0] - 1, val[1] - 1])
        # print(res)
        return res