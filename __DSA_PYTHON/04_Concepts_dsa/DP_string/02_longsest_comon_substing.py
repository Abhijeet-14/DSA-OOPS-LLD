def longest_common_substing(m, n, i, j, ans):
    if i == 0 or j == 0:
        return ans

    if m[i - 1] == n[j - 1]:
        return longest_common_substing(m, n, i - 1, j - 1, ans + 1)

    return max(
        ans,
        max(
            longest_common_substing(m, n, i - 1, j, 0),
            longest_common_substing(m, n, i, j - 1, 0),
        ),
    )


string = "abcdef"
string = "zabcded"
n = "".join(reversed(string))
# print(n)

N = len(string)
# print(N)
print(longest_common_substing(string, n, N, N, 0))
