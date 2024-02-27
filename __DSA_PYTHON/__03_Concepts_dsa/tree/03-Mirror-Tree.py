class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def mirror_tree(root):
    if root is None:
        return None

    # Swap left and right subtrees
    root.left, root.right = root.right, root.left

    # Recursively mirror the left and right subtrees
    mirror_tree(root.left)
    mirror_tree(root.right)

    return root


# Example usage:
# Constructing a simple binary tree
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print("Original Tree:")


# Function to print the tree (in-order traversal)
def print_tree(node):
    if node:
        print_tree(node.left)
        print(node.value, end=" ")
        print_tree(node.right)


print_tree(root)

# Create the mirror of the tree
mirror_root = mirror_tree(root)

print("\nMirror Tree:")
# Print the mirror tree
print_tree(mirror_root)
