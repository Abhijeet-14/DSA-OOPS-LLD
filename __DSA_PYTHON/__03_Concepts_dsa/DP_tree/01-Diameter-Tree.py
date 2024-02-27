class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def height(node):
    if node is None:
        return 0
    return 1 + max(height(node.left), height(node.right))


def diameter_Brute_Force(root):
    if root is None:
        return 0

    # Calculate the height of the left and right subtrees
    left_height = height(root.left)
    right_height = height(root.right)

    # Calculate the diameter_Brute_Force considering paths that pass through the root
    diameter_root = left_height + right_height + 1

    # Calculate the diameter_Brute_Force in the left subtree
    diameter_left = diameter_Brute_Force(root.left)

    # Calculate the diameter_Brute_Force in the right subtree
    diameter_right = diameter_Brute_Force(root.right)

    # Return the maximum of the three diameters
    return max(diameter_root, max(diameter_left, diameter_right))


# Example usage:
# Constructing a simple binary tree
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.right = TreeNode(6)

# Output the diameter_Brute_Force
print("Diameter of the tree, TC(O(N^2)):", diameter_Brute_Force(root))
print(
    "TC(O(N^2) - This is because, for each node, the height function is called, and it traverses the subtree below that node, resulting in a nested traversal for each node. "
)
