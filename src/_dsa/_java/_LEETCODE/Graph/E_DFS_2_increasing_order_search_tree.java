package _dsa._java._LEETCODE.Graph;

import java.util.*;

// Question: https://leetcode.com/problems/increasing-order-search-tree/
//
// RESPONSE: NOT SOLVED, 
// Optimize 1: TC-N SC- N

public class E_DFS_2_increasing_order_search_tree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode head = increasingBST(root);

        System.out.println("OPTIMIZE: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }

    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();

        inOrder(root, vals);

        TreeNode ans = new TreeNode(0);
        TreeNode curr = ans;

        for (int v : vals) {
            curr.right = new TreeNode(v);
            curr = curr.right;
        }

        return ans.right;
    }

    public static void inOrder(TreeNode node, List<Integer> vals) {
        if (node == null)
            return;
        inOrder(node.left, vals);
        vals.add(node.val);
        inOrder(node.right, vals);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
