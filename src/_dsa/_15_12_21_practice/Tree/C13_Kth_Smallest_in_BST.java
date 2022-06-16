package _dsa._15_12_21_practice.Tree;

import java.util.ArrayList;
import java.util.List;

public class C13_Kth_Smallest_in_BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // logic make Inorder Array -> and find k-1 position elemnet

    static int k;
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        k = 3;
        findKth(root);
        System.out.println("Solution1: " + arr.get(k - 1).data);
        findKth_2(root);
    }

    static List<Node> arr = new ArrayList<>();

    private static void findKth(Node root) {
        if(root == null)
            return;

        findKth(root.left);
        arr.add(root);
        findKth(root.right);
    }


    private static void findKth_2(Node root) {
        if(root == null)
            return;

        findKth_2(root.left);
        if(k-1==0)
            System.out.println("Solution2: " + root.data);
        k--;
        findKth_2(root.right);
    }
}
