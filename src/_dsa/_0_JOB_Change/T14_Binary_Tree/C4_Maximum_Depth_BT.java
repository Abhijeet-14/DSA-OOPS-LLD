package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C4_Maximum_Depth_BT {
    // Question: https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = maxDepth(root);

        System.out.println("Result: " + ans);

    }

    public static  int maxDepth(TreeNode root) {
        return inorder(root, 0); // O(N) - as going to each element once only.
    }
    public static int inorder(TreeNode root, int count){
        if(root == null)
            return 0;

        int new_val = Math.max(inorder(root.left, count+1), inorder(root.right, count+1));

        return new_val + 1;
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
