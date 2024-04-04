""" Problem: [https://leetcode.com/problems/minimum-absolute-difference/]
"""
class Solution:
    def minimumAbsDifference(self, arr: list[int]) -> list[list[int]]:
        """
        TC - O(NlogN)
        AS - O(N)
        Approach:
        - 2 task
            - find min_diff
            - find their pair
        Step 1: find min_diff
            - sort arr
            - then compare diff bw consecutive element
            - and get min_diff
        Step 2: find Pair:
            - store all val in set
            - now loop over and see val-min_diff is in set
            - if found - then pair
            - and store in tuple with min_val at 0 and max_val at 1 

        """
        val_set= set(arr)

        copy_arr = arr
        copy_arr.sort()

        min_diff = float("inf")
        for idx in range(len(copy_arr)-1):
            min_diff = min(
                min_diff, 
                copy_arr[idx+1]-copy_arr[idx] 
            )

        res=[]
        for val in arr:
            curr_diff = val-min_diff
            if curr_diff in val_set:
                pair_min = min(curr_diff, val)
                pair_max = max(curr_diff, val)
                res.append((pair_min, pair_max))
            
        res.sort(key= lambda x: x[0])
        return res

        
