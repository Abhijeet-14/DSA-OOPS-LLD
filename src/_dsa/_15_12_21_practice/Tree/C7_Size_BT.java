package _dsa._15_12_21_practice.Tree;

public class C7_Size_BT {
    // count total no of Node in this
    private static  class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(8);
        root.right = new Node(20);

        root.right.left = new Node(30);
        root.right.right = new Node(40);

        int size = sizeBT(root);
        System.out.println("Size O(N): " + size);
    }

    private static int  sizeBT(Node root) {
        if(root == null)
            return 0;

        return 1 + sizeBT(root.left) + sizeBT(root.right);
    }
}
