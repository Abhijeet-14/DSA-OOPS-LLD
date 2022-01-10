package _dsa._15_12_21_practice.Tree;

public class C6_Print_N_At_K_Distance {
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
        root.left.left = new Node(18);
        root.right = new Node(30);

        root.right.left = new Node(40);
        root.right.right = new Node(60);

        int k = 2;
        printAtKDistance(root, k);
    }

    private static void printAtKDistance(Node root, int k) {
        if(root == null)
            return;

        if(k == 0) {
            System.out.print(root.data + " - ");
            return;
        }

        printAtKDistance(root.left, k - 1);
        printAtKDistance(root.right, k - 1);

    }
}
