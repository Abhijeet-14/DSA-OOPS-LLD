package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C6_Is_Same_Tree {
    // Question: https://leetcode.com/problems/same-tree/
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val != q.val)
                return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else if(p == null && q == null){
            return true;
        }
        else{
            return false;
        }
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
