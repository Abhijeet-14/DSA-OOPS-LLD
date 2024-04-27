""" Problem: [https://leetcode.com/problems/longest-common-prefix/description/]
"""


def longest_common_prefix(strs: list[str]) -> str:
    """
    TC - O(N*M), M is len of element
    SC - O(1)
    Edge Case -
        edge_case = ["a"]
        edge_case = ["cir", "car"]
        edge_case = ["aaa", "aa", "aaa"]
    Boundry Case -
        boundry_case = ["dog", "racecar", "car"]
        boundry_case = ["flower","flow","flight"]
    Approach -
    Alternate Solution -
    Tradeoff -
    Spot Pattern -
    """

    res = strs[0]

    for idx in range(1, len(strs)):  # O(N)
        curr = strs[idx]
        match_count = 0
        for i in range(len(curr)):  # O(M)
            if i < len(res):
                if not curr[i] == res[i]:
                    break
                match_count += 1
        res = curr[:match_count]

    return res


edge_case = ["a"]
edge_case = ["cir", "car"]
edge_case = ["aaa", "aa", "aaa"]
edge_case = ["dog", "racecar", "car"]
edge_case = ["flower", "flow", "flight"]

res = longest_common_prefix(edge_case)
print(res)
