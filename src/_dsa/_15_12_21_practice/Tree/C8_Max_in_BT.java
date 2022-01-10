package _dsa._15_12_21_practice.Tree;

public class C8_Max_in_BT {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(8);
        root.right = new Node(30);

        root.right.left = new Node(20);
        root.right.right = new Node(50);

        int _max = maxInBt(root);

        System.out.println("Max in Tree O(N): " + _max);
    }

    private static int maxInBt(Node root) {
        if(root == null)
            return Integer.MIN_VALUE; // PUT MIN value if NULL

        return Math.max(root.data, Math.max(maxInBt(root.left), maxInBt(root.right)));
    }
}
