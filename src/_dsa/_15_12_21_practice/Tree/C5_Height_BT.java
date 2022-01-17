package _dsa._15_12_21_practice.Tree;

public class C5_Height_BT {


    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(8);
        root.right = new Node(30);

        root.right.left = new Node(40);
        root.right.right = new Node(60);

        int height = height(root);

        System.out.println("Height of Tree O(N): " + height);
    }

    private static int height(Node root) {
        if(root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
