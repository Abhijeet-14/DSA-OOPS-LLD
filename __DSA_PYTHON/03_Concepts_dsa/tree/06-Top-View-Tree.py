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

    def pre_order_top_view(self, root, hd):
        if not root:
            return

        root.hd = hd
        self.horizontal_dict[hd] = self.horizontal_dict.get(hd, []) + [root.key]

        self.pre_order_top_view(root.left, root.hd - 1)

        self.pre_order_top_view(root.right, root.hd + 1)

    def top_view(self):
        if not self.root:
            return []

        top_view_nodes = []
        visited_hd = set()
        queue = deque([self.root])

        while queue:
            node = queue.popleft()
            hd = node.hd

            if hd not in visited_hd:
                top_view_nodes.append(node.key)
                visited_hd.add(hd)

            if node.left:
                node.left.hd = hd - 1
                queue.append(node.left)
            if node.right:
                node.right.hd = hd + 1
                queue.append(node.right)

        return top_view_nodes


# Example usage:
tree = BinaryTree()
tree.root = BinaryTree.Node(1)
tree.root.left = BinaryTree.Node(2)
tree.root.right = BinaryTree.Node(3)
tree.root.left.left = BinaryTree.Node(4)
tree.root.left.right = BinaryTree.Node(5)
tree.root.right.left = BinaryTree.Node(6)
tree.root.right.right = BinaryTree.Node(7)

print("Top View of Binary Tree:", tree.top_view())

tree.pre_order_top_view(tree.root, 0)
print(tree.horizontal_dict)
