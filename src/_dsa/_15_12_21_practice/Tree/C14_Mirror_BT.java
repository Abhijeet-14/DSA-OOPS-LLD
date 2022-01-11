package _dsa._15_12_21_practice.Tree;

public class C14_Mirror_BT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // logic make Inorder Array -> and find k-1 position elemnet
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.print("Original: ");
        inOrder(root);
        mirror(root);
        System.out.print("\nMirror: ");
        inOrder(root);
        System.out.println("\nTC: O(N)");
    }

    private static void mirror(Node root) {
        if(root == null)
            return;

        Node temp = root.right;
        if(root.left != null)
            root.right = root.left;
        root.left = temp;

        mirror(root.left);
        mirror(root.right);

    }

    private static void inOrder(Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }
}
