package _dsa._15_12_21_practice.Tree;

import java.util.Stack;

public class C9_Iterative_Traversal {
    static class Node {
        int data;
        Node left, right;

        private Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(12);
        root.left.right = new Node(18);

        root.right.left = new Node(38);
        root.right.right = new Node(42);

        iterativeInO(root);
        iterativePreO(root);
        iterativePostO(root);
    }

    private static void iterativePreO(Node root) {
        if(root == null)
            return;
        Node temp = root;

        Stack<Node> s = new Stack<>();
        s.add(temp);

        while(temp != null && !s.isEmpty()) {
            temp = s.pop();
            if(temp.right != null)
                s.add(temp.right);
            System.out.print(temp.data + ", ");
            if(temp.left != null)
                s.add(temp.left);
        }

        System.out.println("\n O(N)");
    }

    private static void iterativeInO(Node root) {
        if(root == null)
            return;
        Node temp = root;

        Stack<Node> s = new Stack<>();

        while(temp != null || !s.isEmpty()) {
            while(temp!=null) {
                s.add(temp);
                temp = temp.left;
            }

            temp = s.pop();
            System.out.print(temp.data + ", ");
            temp = temp.right;
        }

        System.out.println("\n O(N)");
    }

    private static void iterativePostO(Node root){
        if(root == null)
            return;

        Stack<Node> s=new Stack<>();

    }
}
