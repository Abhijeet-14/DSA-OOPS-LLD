
def solve(n):
    if n ==0:
        return
    solve(n-1)
    print(n)

solve(5)