def solve(n, ssum):
    if n == 0:
        return ssum
    
    return solve(n-1, ssum+n)

sum_of_first_n_nos = solve(5, 0)
print(sum_of_first_n_nos)