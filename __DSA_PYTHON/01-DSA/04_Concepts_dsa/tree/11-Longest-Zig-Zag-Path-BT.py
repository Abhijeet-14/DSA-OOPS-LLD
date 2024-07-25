""" Problem: [https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/]"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: 'TreeNode') -> int:
        """
        TC - O(N)
        Algo:
            - zig-zag can form bw any node-to-node.
            - so if going -- same direction -- make cnt = 0
            - opposite direction -- make cnt = cnt+1
            - max cnt of (left, right)
        """
        def solve(node, dir, cnt):
            if not node:
                return cnt
            
            if dir == 0: # same dir(left) - 0 -- opp dir = 1
                cnt_left, cnt_right = 0, cnt

            if dir == 1: # same dir(right) - 0
                cnt_left, cnt_right = cnt, 0

            return max(
                solve(node.left, 0, cnt_left + 1),
                solve(node.right, 1, cnt_right + 1),
            )

        if not root:
            return 0

        res = max(solve(root.left, 0, 1), solve(root.right, 1, 1))
        return res - 1
