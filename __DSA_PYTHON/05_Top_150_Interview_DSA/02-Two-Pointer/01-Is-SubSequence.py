""" Problem: [https://leetcode.com/problems/is-subsequence/]
"""
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        si, ti = 0, 0

        N, M = len(s), len(t)

        if N == 0:
            return True
        if M == 0:
            return False
        while ti < M and si<N:
            if s[si] == t[ti]:
                si += 1
            ti += 1

        return si == N
