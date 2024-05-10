package _dsa._15_12_21_practice.Tree;

public class C2_BST {
    static Node root = null;

    public static void main(String[] args) {
        int arr[] = {8, 6, 11, 3, 14, 7, 16, 1, 9};

        for(int val : arr)
            insertBST(val);

        postOrder(root);
    }

    private static void insertBST(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }

        Node currNode = null;
        Node temp = root;

        int sign = 0;
        while(temp != null) {
            currNode = temp;
            if(val > temp.data) {
                temp = temp.right;
                sign = 1;
            } else {
                temp = temp.left;
                sign = -1;
            }
        }

        if(sign == 1)
            currNode.right = new Node(val);
        if(sign == -1)
            currNode.left = new Node(val);
//        System.out.print(currNode.data + " ");
    }

    private static void postOrder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        postOrder(root.left);
        postOrder(root.right);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

    }
}
