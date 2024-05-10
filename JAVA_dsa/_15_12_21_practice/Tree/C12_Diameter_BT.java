package _dsa._15_12_21_practice.Tree;

public class C12_Diameter_BT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // DIAMETER: longest path b2w any 2 nodes in a tree.
    // length b2w node is no of edges
    // 2 cases - D with root & D w/o root
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);
//        root.right.left = new Node(2);

        int res = diameter(root);
        System.out.println("Diameter by Edges O(N): " + (res - 1));
    }

    private static int diameter(Node root) {
        if(root == null)
            return 0;

        // Diameter = leftH + rightH + 1(Node)
        int lH = height(root.left);
        int rH = height(root.right);
        int newD = lH + rH + 1;

        // check longest bw rightD & leftD
        int lD = diameter(root.left);
        int rD = diameter(root.right);

        // max bw newD & children D
        return Math.max(newD, Math.max(lD, rD));

    }

    private static int height(Node root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
