package _dsa._15_12_21_practice.Tree;

public class C1_BinaryTree {
    public static void main(String[] args) {

        Node root = new Node(0);

        root.left = new Node(1);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);


        System.out.print("InOrder: ");
        inOrder(root);

        System.out.print("\nPreOrder: ");
        preOrder(root);

        System.out.print("\nPostOrder: ");
        postOrder(root);
    }

    private static void inOrder(Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
