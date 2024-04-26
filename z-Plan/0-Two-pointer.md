# Two Pointer

1. https://leetcode.com/problems/subarray-sum-equals-k/solutions/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers/

# ChatGPT Code
Explanation:
    - Initialize Two Pointers: often at start and end of the array.

    - Move Pointers Towards Each Other or Apart: 
        towards each other (contracting the window)
        apart (expanding the window).
    
    - Check Condition and Optimize: 
        Check a certain condition at each step involving the elements pointed to by the two pointers. 
        Adjust pointers and update data structures accordingly. 
        Optimize the algorithm by avoiding redundant computations.

# Input: nums = [2, 7, 11, 15], target = 9
# Output: [0, 1] (nums[0] + nums[1] equals 9)

def two_sum(nums, target):
    left, right = 0, len(nums) - 1

    while left < right:
        current_sum = nums[left] + nums[right]

        if current_sum == target:
            return [left, right]
        elif current_sum < target:
            left += 1
        else:
            right -= 1

# Example usage:
nums = [2, 7, 11, 15]
target = 9
result = two_sum(nums, target)
print(result)





# ChatGPT Q
Certainly! Here are 25 two-pointer problems from LeetCode with concise statements:

### 1. **Two Sum II - Input array is sorted**
Find two numbers in a sorted array that add up to a specific target.

### 2. **Container With Most Water**
Maximize the area formed between vertical lines in an array representing container heights.

### 3. **3Sum**
Find all unique triplets in an array that add up to a specific target.

### 4. **3Sum Closest**
Find three integers in an array whose sum is closest to a target.

### 5. **Remove Duplicates from Sorted Array II**
Remove duplicates in a sorted array, allowing at most two duplicates.

### 6. **Remove Element**
Remove all instances of a value in-place in an array.

### 7. **Linked List Cycle II**
Detect the starting node of a cycle in a linked list.

### 8. **Sort Colors**
Sort an array of 0s, 1s, and 2s in-place.

### 9. **Valid Palindrome**
Check if a string is a palindrome, considering only alphanumeric characters.

### 10. **Minimum Size Subarray Sum**
Find the minimum size of a contiguous subarray with a sum ≥ a given target.

### 11. **Longest Substring Without Repeating Characters**
Find the length of the longest substring without repeating characters.

### 12. **Merge Sorted Array**
Merge two sorted arrays into one sorted array.

### 13. **Palindrome Linked List**
Check if a linked list is a palindrome.

### 14. **Max Consecutive Ones III**
Find the longest subarray with at most k zeros.

### 15. **Intersection of Two Linked Lists**
Find the node at which the two linked lists intersect.

### 16. **Minimum Window Substring**
Find the minimum window in a string that contains all characters of another string.

### 17. **Partition List**
Partition a linked list around a given value.

### 18. **Subarray Product Less Than K**
Count the number of contiguous subarrays where the product of elements is less than k.

### 19. **Trapping Rain Water**
Compute how much water can be trapped after raining.

### 20. **Longest Consecutive Sequence**
Find the length of the longest consecutive sequence in an unsorted array.

### 21. **Valid Parentheses**
Determine if a given string of parentheses is valid.

### 22. **Reverse Vowels of a String**
Reverse only the vowels of a string.

### 23. **Remove Nth Node From End of List**
Remove the nth node from the end of a linked list.

### 24. **Find the Duplicate Number**
Find the duplicate number in an array containing n + 1 integers.

### 25. **Valid Palindrome II**
Check if it's possible to make a string palindrome by removing at most one character.

These concise statements cover various two-pointer problems from LeetCode, spanning arrays, linked lists, strings, and more.