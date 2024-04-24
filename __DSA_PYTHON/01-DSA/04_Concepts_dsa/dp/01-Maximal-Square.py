# DP - init, base-condi, recursion
def maximal_square(matrix: list[list[str]]):
    """
    TC - O(N*M)
    AS - O(N*M)
    """

    R, C = len(matrix), len(matrix[0])

    dp = {}

    def helper(r, c):

        # base condi
        if r>=R or c>=C: return 0

        if (r,c) not in dp:
            # recursion
            down = helper(r+1,c)
            right = helper(r,c+1)
            diag = helper(r+1, c+1)

            # initalization
            dp[(r,c)] = 0
            if matrix[r][c] == "1":
                dp[(r,c)] = 1 + min(down, right, diag)
        
        return dp[(r,c)]
    
    helper(0, 0)

    return max(dp.values())**2


matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]

print(maximal_square(matrix))