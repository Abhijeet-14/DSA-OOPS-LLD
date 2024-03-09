class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None


tree = BinaryTree()


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
