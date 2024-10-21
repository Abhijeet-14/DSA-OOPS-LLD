def solve(n):
    if n == 0: return
    print(n)
    solve(n-1)

solve(5)