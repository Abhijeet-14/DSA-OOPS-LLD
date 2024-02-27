# Backtracking

## 1. https://leetcode.com/problems/permutations/solutions/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)/

## 2. https://leetcode.com/problems/permutations/solutions/18284/Backtrack-Summary:-General-Solution-for-10-Questionsh/

## 3. https://leetcode.com/discuss/general-discussion/665604/Important-and-Useful-links-from-all-over-the-LeetCode

# ChatGPT Code:

```
def backtrack(nums, path, result):
    # Base case: if the path has the same length as nums, we found a permutation
    if len(path) == len(nums):
        result.append(path[:])
        return

    # Explore all possible choices
    for num in nums:
        # Skip if the number is already in the current path
        if num in path:
            continue
        # Make a choice
        path.append(num)
        # Recur to explore further choices
        backtrack(nums, path, result)
        # Backtrack by undoing the choice
        path.pop()

def find_permutations(nums):
    result = []
    backtrack(nums, [], result)
    return result

# Example usage:
nums = [1, 2, 3]
permutations = find_permutations(nums)
print(permutations)

```

# ChatGPT Question:

Certainly! Here are some backtracking problems from LeetCode along with their expectations, time complexity, and space complexity:

## 1. Permutations

Problem: Given a collection of distinct integers, return all possible permutations.

Expectation: Return a list of all permutations.
Time Complexity: O(n!), where n is the number of elements.
Space Complexity: O(n) (depth of the recursion stack).

## 2. Subsets

Problem: Given a set of distinct integers, nums, return all possible subsets (the power set).

Expectation: Return a list of all subsets.
Time Complexity: O(2^n), where n is the number of elements.
Space Complexity: O(n) (depth of the recursion stack).

## 3. Combination Sum

Problem: Given a set of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to the target.

Expectation: Return a list of all unique combinations.
Time Complexity: O(n^(target/min(candidate))), where n is the number of candidates.
Space Complexity: O(target/min(candidate)) (depth of the recursion stack).

## 4. N-Queens

Problem: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens threaten each other.

Expectation: Return all distinct solutions.
Time Complexity: O(n!), where n is the number of queens.
Space Complexity: O(n) (depth of the recursion stack).

## 5. Word Search

Problem: Given an m x n grid of characters board and a string word, return true if word exists in the grid.

Expectation: Return true if the word exists, false otherwise.
Time Complexity: O(m _ n _ 4^L), where m and n are the dimensions of the grid, and L is the length of the word.
Space Complexity: O(L) (depth of the recursion stack).

## 6. Sudoku Solver

Problem: Write a program to solve a Sudoku puzzle.

Expectation: Modify the input board to solve the puzzle.
Time Complexity: O(9^(N^2)), where N is the size of the Sudoku grid.
Space Complexity: O(N^2).

## 7. Palindrome Partitioning

Problem: Given a string s, partition it such that every substring of the partition is a palindrome.

Expectation: Return all possible palindrome partitioning.
Time Complexity: O(2^n), where n is the length of the string.
Space Complexity: O(n) (depth of the recursion stack).

## 8. Combination Sum II

Problem: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the ## candidate numbers sum to the target. Each number in candidates may only be used once in the combination.

Expectation: Return a list of all unique combinations.
Time Complexity: O(2^n), where n is the number of candidates.
Space Complexity: O(n) (depth of the recursion stack).

## 9. Generate Parentheses

Problem: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Expectation: Return all valid combinations.
Time Complexity: O(4^n / sqrt(n)), where n is the number of pairs.
Space Complexity: O(n) (depth of the recursion stack).

## 10. Letter Combinations of a Phone Number

Problem: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent on a phone.

Expectation: Return all possible letter combinations.
Time Complexity: O(4^n), where n is the length of the input digits.
Space Complexity: O(n) (depth of the recursion stack).

## 11. Word Search II

Problem: Given a 2D board and a list of words from the dictionary, find all words in the board.

Expectation: Return a list of words found in the board.
Time Complexity: O(M _ N _ 4^L + W _ L), where M and N are the dimensions of the board, L is the maximum length of a word, and W is the number of words.
Space Complexity: O(W _ L) (for the set of words).

## 12. Regular Expression Matching

Problem: Implement regular expression matching with support for '.' and '\*'.

Expectation: Return true if the input string matches the pattern, false otherwise.
Time Complexity: O(2^(N+M)), where N is the length of the input string and M is the length of the pattern.
Space Complexity: O(NM).

## 13. Word Squares

Problem: Given a set of words (without duplicates), find all word squares you can build from them.

Expectation: Return all valid word squares.
Time Complexity: O(N!), where N is the number of words.
Space Complexity: O(N^2) (size of the prefix matrix).

## 14. Expression Add Operators

Problem: Given a string num that contains only digits and an integer target, return all possibilities to add binary operators (+, -, or \*) between the digits so that the expression becomes equal to the target.

Expectation: Return all valid expressions.
Time Complexity: O(4^n), where n is the length of the input string.
Space Complexity: O(n) (depth of the recursion stack).

## 15. Restore IP Addresses

Problem: Given a string s containing only digits, restore it by returning all possible valid IP address combinations.

Expectation: Return all valid IP addresses.
Time Complexity: O(3^4), as there are a maximum of 3^4 possible combinations for each segment in an IP address.
Space Complexity: O(1) (constant space).

## 16. Gray Code

Problem: The gray code is a binary numeral system where two successive values differ in only one bit. Given an integer n representing the total number of bits in the code, print the sequence of gray code.

Expectation: Return the gray code sequence.
Time Complexity: O(2^n), where n is the given number of bits.
Space Complexity: O(1).

## 17. Unique Paths III

Problem: On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.
2 represents the ending square.
0 represents empty squares.
-1 represents obstacles.
The goal is to find the number of 4-directionally adjacent empty squares such that the path from the starting square to the ending square visits each empty square exactly once.
Expectation: Return the number of unique paths.
Time Complexity: O(4^(N _ M)), where N and M are the dimensions of the grid.
Space Complexity: O(N _ M).

## 18. Sudoku Solver II

Problem: Write a program to solve a Sudoku puzzle.

Expectation: Modify the input board to solve the puzzle.
Time Complexity: O(9^(N^2)), where N is the size of the Sudoku grid.
Space Complexity: O(N^2).

## 19. Tug of War

Problem: Given a set of n integers, divide the set into two subsets with minimum difference between their sums.

Expectation: Return the two subsets with minimum difference.
Time Complexity: O(2^N), where N is the size of the input set.
Space Complexity: O(N).

## 20. Kth Permutation Sequence

Problem: The set [1,2,3,...,n] contains a total of ## n! unique permutations. By listing and labeling all of the permutations in order, find the kth permutation.

Expectation: Return the kth permutation.
Time Complexity: O(N), where N is the number of elements.
Space Complexity: O(N).

## 21. Total Hamming Distance

Problem: The Hamming distance between two integers is the number of positions at which the ## corresponding bits are different. Given an integer array nums, return the sum of Hamming distances between all pairs of the integers.

Expectation: Return the total Hamming distance.
Time Complexity: O(n), where n is the number of elements in the array.
Space Complexity: O(1).
