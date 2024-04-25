"""Problem[Medimum]: [https://leetcode.com/problems/sort-an-array/description/] 
Sort An Array w/o builtin function
"""

class Solution:
    def sortArray(self, nums: list[int]) -> list[int]:
        """ 
        TC - O(N)
        SC - O(N)
        """
        def merge_2_arr(arr, left, right):
            i, j, k = 0, 0, 0
            n, m, p = len(left), len(right), len(arr)

            while i < n and j < m:
                if left[i] < right[j]:
                    arr[k] = left[i]
                    i += 1
                else:
                    arr[k] = right[j]
                    j += 1
                k += 1

            while i < n:
                arr[k] = left[i]
                i += 1
                k += 1

            while j < m:
                arr[k] = right[j]
                j += 1
                k += 1

        def divide_to_2_arr(arr):
            if len(arr) < 2:
                return

            mid = (len(arr)) // 2
            left = arr[:mid]
            right = arr[mid:]

            divide_to_2_arr(left)
            divide_to_2_arr(right)

            merge_2_arr(arr, left, right)

        divide_to_2_arr(nums)
        return nums


print(Solution().sortArray([5,3,4,1,2]))