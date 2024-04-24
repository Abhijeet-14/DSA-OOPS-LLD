""" Problem: [https://leetcode.com/problems/minimum-window-substring/]
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        TC - O(N*M) -- optimized - ??
        Approach:
            - first count occurance of 't' in dict
            - slid-window over 's', with for loop
            - count occurance of 's'
            - if its match ->
                    - then while loop until no match
                    - and increase left + 1
                    - decrease occurrance 's' per char and delete if 0
                    - calculate min length bw curr_str & prev_min_str
                    - and update prev_min_str
        Edge Case:
            - len_s < len_t
        """
        N = len(s)
        if len(s) < len(t):
            return ""

        occur_t = {}
        occur_s = {}
        for ch in t:
            occur_t[ch] = occur_t.get(ch, 0) + 1

        def check(curr_str):  # O(M)
            for ch in t:
                if ch not in curr_str or occur_t[ch] > occur_s[ch]:
                    return False
            return True

        def check_2():  # O(1)
            for key, val in occur_t.items():
                if key not in occur_s or val > occur_s[key]:
                    return False
            return True

        left = 0
        min_str = ""
        min_len = float("inf")
        for right in range(N):
            # O(N) -> O(N*M) [check()]
            # Optimized O(N)*1 [check_2()]
            ch = s[right]
            if ch in t:
                occur_s[ch] = occur_s.get(ch, 0) + 1

            curr_str = s[left : right + 1]

            # while check(curr_str):  # O(M)
            while check_2():  # O(1)
                if min_len > len(curr_str):
                    min_str = curr_str
                    min_len = len(curr_str)

                ch = curr_str[0]
                if ch in t:
                    occur_s[ch] -= 1
                    if occur_s[ch] <= 0:
                                del occur_s[ch]
                curr_str = curr_str[1:]
                left += 1
        return min_str


    def minWindow_2(self, s: str, t: str) -> str:
        if len(s)<len(t): return ""
        dict_t = {}
        for ch in t:
            dict_t[ch] = dict_t.get(ch, 0) + 1
        
        min_len = float("inf")
        min_curr = ""
        dict_s = {}

        def match(ch_t):   
            if ch_t not in dict_t: return False

            if len(dict_t.keys()) != len(dict_s.keys()):
                return False

            for ch_q, val in dict_t.items():
                if not dict_s.get(ch_q) or dict_s[ch_q]<val:
                    return False
            return True

        # right index
        l=0
        for r in range(len(s)):
            ch = s[r]
            if ch in dict_t:
                dict_s[ch] = dict_s.get(ch, 0) + 1
         
            while match(ch):
                if min_len >= r-l+1:     
                    min_len =  r-l+1
                    min_curr = s[l:r+1]

                if s[l] in dict_t:
                    dict_s[s[l]] -= 1
                    if dict_s[s[l]] == 0:
                        del dict_s[s[l]]
                l+=1 

        return min_curr