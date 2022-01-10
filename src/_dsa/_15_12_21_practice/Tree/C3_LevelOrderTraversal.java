package _dsa._15_12_21_practice.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class C3_LevelOrderTraversal {
    static Node root = null;

    public static void main(String[] args) {
        int arr[] = {8, 6, 11, 3, 14, 7, 16, 1, 9, 13};

        for(int val : arr)
            insertBST(val);

        Node temp = root;
        preOrder(temp);
        System.out.println();

        levelOrderTravel(root);
    }

    private static void preOrder(Node temp) {
        if(temp == null)
            return;
        System.out.print(temp.data + "-> ");
        preOrder(temp.left);
        preOrder(temp.right);
    }

    private static void levelOrderTravel(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;
        while(!q.isEmpty()) {
            temp = q.poll();
            System.out.print(temp.data + "->");
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
    }

    private static void insertBST(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }

        Node temp = null;
        Node currNode = root;
        int sign = 0;
        while(currNode != null) {
            temp = currNode;
            if(val > currNode.data) {
                currNode = currNode.right;
                sign = 1;
            } else {
                currNode = currNode.left;
                sign = -1;
            }
        }

        if(sign == 1)
            temp.right = new Node(val);
        if(sign == -1)
            temp.left = new Node(val);
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
