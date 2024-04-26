"""
Given a binary tree, a target node in the binary tree, and an integer value k, 
print all the nodes that are at distance k from the given target node. 

No parent pointers are available.

# assume - Tree

# 0 - 1, 2

# A - B , C
# B - D E
# C - G, H
# G - M

# target - C ---> find at k=2
# res - B, M
"""

# child at K distance -- 
# C(K=2) --> G(1) --> M(0) -- 0 - M - store

# parent -- 
# node 
    # parent
        # super parent
        # other child
# E(2) -> B(1) -> A(0)
    # D(0)

# A -> B(*parent) -- referenc of A

# C(*A) -> childs -> parent
# new function -- node at dist
# store -- k==0

# target == C (*A)
    # fun(from child) -- 1
    # func_parent_child(A) -- 
    # break

# func_parent_child(parent, K)
    # if K==0:
        # parrent -- store 
    
    # should target - node
    # other_childs(B, k-1)
    # func_parent_child(P, K-1)


res =  []

class Node:
    def __inti__(self, val, parent):
        self.val = val
        self.parent = parent
        self.left = None
        self.right = None

def func_parent(node, parent, target, k):
    if k==0: res.append(node.val)

    if node.left != target:
        func_parent(node.left, node)
    if node.right != target:
        func_parent(node.right, node)
    
    # parent - to - parent



# distanc of C from root - 5
# root -- find all node -- 5-K -- 5-2 - 3
