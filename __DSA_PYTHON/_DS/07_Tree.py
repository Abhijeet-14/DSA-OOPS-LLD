class Tree:
    def __init__(self, key, left=None, right=None):
        self.key = key
        self.left = None
        self.right = None


def insert(root, key):
    if not root:
        return Tree(key)

    if key < root.key:
        root.left = insert(root.left, key)
    else:
        root.right = insert(root.right, key)

    return root


def inorder_trav(root):
    if not root:
        return

    inorder_trav(root.left)
    print(root.key, end=" -> ")
    inorder_trav(root.right)


root = None
nodes = [5, 3, 7, 2, 4, 6, 8]
for node in nodes:
    root = insert(root, node)

inorder_trav(root)
