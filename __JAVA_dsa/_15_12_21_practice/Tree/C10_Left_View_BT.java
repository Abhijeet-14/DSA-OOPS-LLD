package _dsa._15_12_21_practice.Tree;

//    10
// 20     30
//      25   35
//        28

import java.util.LinkedList;
import java.util.Queue;

// Result -> 10 20 25 28
public class C10_Left_View_BT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // make level array
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root.right.left.right = new Node(6);


        leftView(root);
    }


    private static void leftView(Node root) {
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;

        boolean flag = true;
        while(!q.isEmpty()) {
            temp = q.poll();
            if(temp == null) {
                flag = true;
            } else {
                if(flag) {
                    System.out.print(temp.data + ", ");
                    flag = false;
                    q.add(null);
                }
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }

    }
}
