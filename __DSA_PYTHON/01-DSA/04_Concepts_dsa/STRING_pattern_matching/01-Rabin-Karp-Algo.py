def search_Rabin_Karp(pat, txt):
    """
    TC - O(N+M) for best case
    and Worst Case, TC - O(N*M)
    Worst Case:
        txt: AAAAAAAAAAA
        pat: AAA
    TestCase passed: 1022/1121 - TLE
    """
    # code here
    m = len(pat)
    n = len(txt)

    d = 256
    prim = 3 * (10**7)

    pat_hash = 0
    txt_hash = 0
    result = []
    for idx in range(m):
        val = ord(pat[idx])
        pat_hash = (pat_hash * (d) + val) % prim

    for idx in range(n):
        val = ord(txt[idx])
        if idx < m - 1:
            txt_hash = (txt_hash * (d) + val) % prim

        else:
            txt_hash = (txt_hash * (d) + val) % prim

            if txt_hash == pat_hash:

                if txt[idx - m + 1 : idx + 1] == pat:
                    result.append(idx - m + 1 + 1)

            txt_hash = txt_hash - (ord(txt[idx - m + 1]) * (d ** (m - 1))) % prim
            # Ensure the hash value is positive
            if txt_hash < 0:
                txt_hash = txt_hash + prim

    return result if result else [-1]


def search_map(self, pat, txt):
        """
        TC - O(N+M)
        TestCase passed: 1012/1121 - Collision Error
        """
        
        map = {}
        
        n = len(txt)
        m = len(pat)
        for i in range(n-m+1):
            curr_txt = txt[i:i+m]
            map[curr_txt] = map.get(curr_txt, []) + [i]
        
        if map.get(pat):
            return [val+1 for val in map[pat]]
        return [-1]