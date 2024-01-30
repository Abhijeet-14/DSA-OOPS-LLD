# Definition for a  binary tree node
# class TreeNode:
#	def __init__(self, x):
#		self.val = x
#		self.left = None
#		self.right = None

class Solution:
	# @param A : root node of tree
	# @return a list of integers
    def preorderTraversal(self, A):
        st, ans = [], []
        st.append(A)
        while st:
            n = st.pop()
            ans.append(n.val)
            if n.right:
                st.append(n.right)
            if n.left:
                st.append(n.left)
        return ans