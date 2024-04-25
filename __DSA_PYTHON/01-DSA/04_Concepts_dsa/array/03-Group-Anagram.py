class Solution:
    def solution_1(self, strs: list[str]) -> list[list[str]]:
        """
        TC - O(N*MlogM)
        SC - O(N)
        EdgeCase:
            - [ddg, dgg]
        BoundryCase:
            -
        Approach:
            - hashmap {anagram_X: [X]}, X is elemet in array
            - sort the X
            - append it on anagram_X
            - return hashmap - values
        TradeOff:
            -
        AlternateSol:
            - sort of X - take O(MlogM)
            - do it O(M), using array of 26
        Spot patterns
            -
        """

        anagram_group = {}
        for val in strs:  # N
            val2 = "".join(sorted(val))  # MlogM
            anagram_group[val2] = anagram_group.get(val2, []) + [val]
        return anagram_group.values()

    def solution_2(self, strs):
        def anagram_value(val):
            CHAR = [0] * 256
            for ch in val:
                CHAR[ord(ch)] += 1

            new_val = ""
            for idx, i in enumerate(CHAR):
                if i > 0:
                    # to handle edge case ['dddg','dggg'] multiply with repeating number of a char
                    new_val += chr(idx) * i
            return new_val

        anagram_group = {}
        for val in strs:  # N
            val2 = anagram_value(val)  # 26
            anagram_group[val2] = anagram_group.get(val2, []) + [val]
        return anagram_group.values()
