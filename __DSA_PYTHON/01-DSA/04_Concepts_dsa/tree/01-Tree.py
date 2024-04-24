"""
Time Complexity:
1. Inorder - O(N)
1. TopView - O(N)
1. BottomView - O(N)
1. Left View - O(N)
1. Right View - O(N)
1. Height  - O(N)
1. Size  - O(N)
"""


class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, val):
        self.root = self._insert(self.root, val)

    def _insert(self, root, val):
        if root is None:
            return Node(val)

        if val < root.val:
            root.left = self._insert(root.left, val)
        else:
            root.right = self._insert(root.right, val)

        return root

    def inorder_traversal(self):
        result = []
        self._inorder_traversal(self.root, result)
        return result

    def _inorder_traversal(self, root, result):
        if root:
            self._inorder_traversal(root.left, result)
            result.append(root.val)
            self._inorder_traversal(root.right, result)


# Example usage:
tree = BinaryTree()
tree.insert(5)
tree.insert(3)
tree.insert(7)
tree.insert(1)
tree.insert(4)
tree.insert(6)
tree.insert(8)

print("Inorder Traversal:", tree.inorder_traversal())


def is_bst(root, min_val, max_val):
    if not root:
        return True

    if min_val <= root.val <= max_val:
        return is_bst(root.left, min_val, root.val) and is_bst(
            root.right, root.val, max_val
        )

    return False


min_val = float("-inf")
max_val = float("inf")
print(is_bst(tree.root, min_val, max_val))
