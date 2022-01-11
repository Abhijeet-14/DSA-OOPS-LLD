package _dsa._15_12_21_practice.Tree;

public class C11_Check_BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(16);

        boolean flag = checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("BST: " + flag);
    }

    private static boolean checkBST(Node root, int minValue, int maxValue) {
        if(root == null)
            return true;

        if(root.data >= minValue && root.data < maxValue) {
            return checkBST(root.left, minValue, root.data)
                    && checkBST(root.right, root.data, maxValue);

        }
        return false;
    }
}
