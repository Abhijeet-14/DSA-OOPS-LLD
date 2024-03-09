from collections import deque


class BinaryTree:
    def __init__(self):
        self.root = None
        self.horizontal_dict = {}

    class Node:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None
            self.hd = 0  # Horizontal distance from the root

    def post_order_top_view(self, root, hd):
        if not root:
            return

        self.post_order_top_view(root.left, root.hd - 1)
        self.post_order_top_view(root.right, root.hd + 1)
        root.hd = hd
        self.horizontal_dict[hd] = self.horizontal_dict.get(hd, []) + [root.key]

    def bottom_view(self):
        if not self.root:
            return []

        bottom_view_nodes = {}
        queue = deque([self.root])

        while queue:
            node = queue.popleft()
            hd = node.hd

            # Update the horizontal distance for the current node
            bottom_view_nodes[hd] = node.key

            if node.left:
                node.left.hd = hd - 1
                queue.append(node.left)
            if node.right:
                node.right.hd = hd + 1
                queue.append(node.right)

        # Sort the result based on horizontal distance
        sorted_bottom_view_nodes = [
            value for key, value in sorted(bottom_view_nodes.items())
        ]

        return sorted_bottom_view_nodes


# Example usage:
tree = BinaryTree()
tree.root = BinaryTree.Node(1)
tree.root.left = BinaryTree.Node(2)
tree.root.right = BinaryTree.Node(3)
tree.root.left.left = BinaryTree.Node(4)
tree.root.right.left = BinaryTree.Node(6)
tree.root.left.right = BinaryTree.Node(5)
tree.root.right.right = BinaryTree.Node(7)

print("Bottom View of Binary Tree:", tree.bottom_view())

tree.post_order_top_view(tree.root, 0)
print(tree.horizontal_dict)
