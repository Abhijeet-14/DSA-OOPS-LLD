package _dsa._java._LEETCODE.Graph;

import java.util.*;

//Question: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//
// RESPONSE: SOLVED (3ms), needs to optimize!

// OPTIMIZE: DFS Approach, 0ms

public class E_DFS_3_maximum_depth_of_n_ary_tree {

    public static void main(String[] args) {

        Node root = new Node(1, new ArrayList<>());

        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(3, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));

        root.children.get(0).children.add(new Node(5, new ArrayList<>()));
        root.children.get(0).children.add(new Node(6, new ArrayList<>()));

        System.out.println("MY APPROACH");
        int count = maxDepth(root);
        System.out.println(count);

        System.out.println("\nOPTIMIZE");
        int count1 = optimizeDFS(root);
        System.out.println(count1);
    }

    // OPTIMIZE
    static int max = 0;

    public static int optimizeDFS(Node root) {
        if (root == null)
            return max;
        return calculateDepth(root, 1);
    }

    public static int calculateDepth(Node node, int count) {

        if (node.children.isEmpty()) {
            max = Math.max(max, count);
        } else {
            count++;
            for (Node child : node.children) {
                calculateDepth(child, count);
            }
        }
        return max;
    }

    // MY APPROACH
    public static int maxDepth(Node root) {
        if (root == null)
            return 0;

        int count = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        Node temp;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.poll();

            if (temp == null) {
                if (q.size() != 0)
                    q.add(null);
                count++;
            } else {
                List<Node> child = temp.children;
                for (int i = 0; i < child.size(); i++) {
                    q.add(child.get(i));
                }
            }
        }
        return count;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
