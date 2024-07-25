"""Leetcode: [https://leetcode.com/problems/path-sum-iii/]"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> int:
        """
        TC - O(N)
        SC - O(N)
        Algo:
            - use 2-Sum + PrefixSum
            - do preorder travel
            - at each node calculate its prefix-sum and 
            - if (prefixSum-target) in map -- increase the cnt by map[key]
            - add preSum in map 
            - remove node from map - once all child are visted
            - intialize map - {0:1} - empty tree
        """
        map = {0:1} # intailize - empty tree sum = 0 
        cnt = 0

        def inorder(node, ssum):
            nonlocal cnt
            if not node:
                return

            prefix_sum = node.val + ssum
            if prefix_sum - targetSum in map.keys():
                cnt += map[prefix_sum-targetSum]

            map[prefix_sum] = map.get(prefix_sum, 0) + 1
            inorder(node.left, prefix_sum)
            inorder(node.right, prefix_sum)

            # remove node pre sum - once all child visited
            map[prefix_sum] -= 1
            if map[prefix_sum] == 0:
                del map[prefix_sum]
                
        inorder(root, 0)
        return cnt
