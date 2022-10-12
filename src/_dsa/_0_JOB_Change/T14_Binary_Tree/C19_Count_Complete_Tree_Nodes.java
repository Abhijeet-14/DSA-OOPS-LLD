package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C19_Count_Complete_Tree_Nodes {
    // Ques: https://leetcode.com/problems/count-complete-tree-nodes/
    public static void main(String[] args) {

    }

    static int count;
    public int countNodes(TreeNode root) {
        count  = 0;

        height_CBT(root);
        return count;
    }

    static int height_CBT(TreeNode root){
        if(root == null)
            return 0;

        count++;
        return 1 + Math.max(height_CBT(root.left), height_CBT(root.right));
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
