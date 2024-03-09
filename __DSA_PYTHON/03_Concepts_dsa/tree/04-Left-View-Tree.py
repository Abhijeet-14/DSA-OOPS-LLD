from collections import deque


class BinaryTree:
    def __init__(self):
        self.root = None

    class Node:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None

    def left_view(self):
        if not self.root:
            return []

        left_view_nodes = []
        queue = deque([(self.root, 0)])  # Each element is a tuple (node, level)

        next_level = 1
        left_view_nodes.append(self.root.key)
        while queue:
            node, level = queue.popleft()
            if level == next_level:
                next_level += 1
                left_view_nodes.append(node.key)

            if node.left:
                queue.append((node.left, level + 1))
            if node.right:
                queue.append((node.right, level + 1))

        return left_view_nodes


# Example usage:
tree = BinaryTree()
tree.root = BinaryTree.Node(1)
tree.root.left = BinaryTree.Node(2)
tree.root.right = BinaryTree.Node(3)
tree.root.left.left = BinaryTree.Node(4)
tree.root.left.right = BinaryTree.Node(5)
tree.root.right.right = BinaryTree.Node(6)
tree.root.left.left.left = BinaryTree.Node(7)

print("Left View of Binary Tree:", tree.left_view())
