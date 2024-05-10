package _dsa._0_JOB_Change.T14_Binary_Tree;

import java.util.Map;
import java.util.TreeMap;

public class C11_Right_view {
    // Question: https://leetcode.com/problems/binary-tree-right-side-view/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        root.right.right.left.right = new TreeNode(12);

        Map<Integer, Integer> ans = new TreeMap<>();

        right_view_tree_node(root, 0, ans);

        System.out.println(ans.values());
    }

    private static void right_view_tree_node(TreeNode root, int level, Map<Integer, Integer> ans) {

        if(root == null)
            return;
        if(!ans.containsKey(level))
            ans.put(level, root.val);
        right_view_tree_node(root.right,level+1, ans);
        right_view_tree_node(root.left,level+1, ans);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
