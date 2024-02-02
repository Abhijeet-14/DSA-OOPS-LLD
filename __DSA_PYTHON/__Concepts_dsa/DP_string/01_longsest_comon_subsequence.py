def longest_common_subsequence(m, n, i, j):
    if i == 0 or j == 0:
        return 0

    if m[i - 1] == n[j - 1]:
        return 1 + longest_common_subsequence(m, n, i - 1, j - 1)

    return max(
        longest_common_subsequence(m, n, i - 1, j),
        longest_common_subsequence(m, n, i, j - 1),
    )


m = "abcdgh"
n = "abedfhr"

N = len(m)
print(longest_common_subsequence(m, n, N, N))
