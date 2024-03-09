"""
The brute-force approach can be optimized using dynamic programming to avoid redundant calculations of heights. 
We can use a recursive function to calculate both the height and the diameter in a single pass. 
This way, we don't repeatedly calculate the height for the same nodes.
"""


class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class Result:
    def __init__(self, height, diameter):
        self.height = height
        self.diameter = diameter


def diameter_optimized(root):
    if root is None:
        return Result(0, 0)

    left_result = diameter_optimized(root.left)
    right_result = diameter_optimized(root.right)

    # Calculate the height of the current node
    current_height = 1 + max(left_result.height, right_result.height)

    # Calculate the diameter considering paths that pass through the current node
    current_diameter = left_result.height + right_result.height + 1

    # Update the diameter result with the maximum of the three diameters
    current_diameter = max(
        current_diameter, max(left_result.diameter, right_result.diameter)
    )

    return Result(current_height, current_diameter)


# Example usage:
# Constructing a simple binary tree
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.right = TreeNode(6)

# Output the diameter
result = diameter_optimized(root)
print("Diameter of the tree:", result.diameter)
