"""Problem: [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/]"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
            TC - O(N)
            SC - O(N)
            Algo:
                - if node is p or q --> return node
                - two case -- find in left -- but not in right ---> return left
                - and -- find in right -- but not in left ---> return right
                - when find both p & q -- return node
                - if None - return None
        """
        def solve(node):
            if node in [None, p, q]:
                return node

            left = solve(node.left)
            right = solve(node.right)

            if left == None:
                return right
            if right == None:
                return left
            
            return node
        return solve(root)