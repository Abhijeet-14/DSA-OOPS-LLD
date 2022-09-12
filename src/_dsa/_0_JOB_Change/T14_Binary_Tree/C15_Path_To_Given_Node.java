package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C15_Path_To_Given_Node {
    // Question: https://www.interviewbit.com/problems/path-to-given-node/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        String res = pathToGivenNode(root);
        System.out.println("Result: " + res);
    }

    static boolean is_there = false;
    static String ans = "";
    public static String pathToGivenNode(TreeNode root) {

        int target = 5;
        path_to_given_node(root, "",  target);

        return ans;
    }

    public static void path_to_given_node(TreeNode root, String curr, int target){
        if(root == null)
            return ;

        if(root.val == target)
            ans = curr + root.val;

        curr += root.val + "->";

        path_to_given_node(root.left, curr, target);
        path_to_given_node(root.right, curr, target);
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
