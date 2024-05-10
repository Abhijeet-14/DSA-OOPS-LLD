package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C14_Binary_Tree_Paths {
    // Questions: https://leetcode.com/problems/binary-tree-paths/
    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        binary_tree_paths(root, ans, "");

        return ans;
    }

    public static void binary_tree_paths(TreeNode root, List<String> ans, String curr){
        if(root == null)
            return;

        if(root.left == null && root.right == null) // at leaf.
            ans.add(curr + root.val);

        curr += root.val + "->"; // add root val to curr

        binary_tree_paths(root.left, ans, curr);
        binary_tree_paths(root.right, ans, curr);
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
