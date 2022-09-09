package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C13_Symmetric_Tree {
    // Question: https://leetcode.com/problems/symmetric-tree/
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return false;

        return solve(root.left, root.right);
    }

    public static boolean solve(TreeNode root_1, TreeNode root_2){
        if(root_1 == null && root_2 == null)
            return true;

        if(root_1 == null || root_2 == null)
            return false;

        if(root_1.val != root_2.val)
            return false;

        return root_1.val == root_2.val && solve(root_1.left, root_2.right) && solve(root_1.right, root_2.left);

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
