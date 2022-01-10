package _dsa._15_12_21_practice.Tree;


import java.util.Stack;

public class C4_LOT_Spiral {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node root;

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        levelOrder_Spiral(root);
        System.out.println("Time - O(n)");
        System.out.println("It take O(n) time and O(n) extra space!!");
    }

    private static void levelOrder_Spiral(Node root) {

        if(root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        Node curr;

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                curr = s1.pop();

                System.out.print(curr.data + " ");
                if(curr.left != null)
                    s2.push(curr.left);
                if(curr.right != null)
                    s2.push(curr.right);

            }
            while(!s2.isEmpty()) {
                curr = s2.pop();

                System.out.print(curr.data + " ");
                if(curr.right != null)
                    s1.push(curr.right);
                if(curr.left != null)
                    s1.push(curr.left);
            }
        }
        System.out.println();
    }
}
