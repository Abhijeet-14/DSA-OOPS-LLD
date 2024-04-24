class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        TC -
        Approach
            - 2 points - left, right
            - dict{char: last_index_of_char}
            - if new_char exist in dict, calculate length(r-l+1), left = right+1, right+1
            - right+1
        """

        left = 0
        right = 0
        N = len(s)
        if N < 2:
            return N

        occur = {}
        max_length = 0
        while left <= right and right < N:
            char = s[right]
            if char in occur and left<=occur[char]:
                left = occur[char]+1
                del occur[char]

            max_length = max(max_length, right - left + 1)
            occur[char] = right
            right += 1

        return max_length
