package _dsa._0_JOB_Change.T14_Binary_Tree;

import java.util.*;

public class C16_Longest_Common_Ancestor {
    // Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(8);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(8);

        TreeNode result = lowestCommonAncestor_O_N(root, p, q);
        if(result != null)
            System.out.println("Result: " + result.val);
        else
            System.out.println("Result: "+ null);
    }

    public static TreeNode lowestCommonAncestor_O_N(TreeNode root, TreeNode p, TreeNode q) {
        // Logic:
        // Following is a simple O(n) algorithm to find the LCA of n1 and n2
        // Find a path from the root to n1 and store it in array.
        // Find a path from the root to n2 and store it in array.
        // Traverse both paths till the values in arrays are the same. Return the common element just before the mismatch.

        List<TreeNode> res1 = new ArrayList<>(); // AS - O(N)
        List<TreeNode> res2 = new ArrayList<>(); // AS - O(N)

        lowest_common_ancestor_O_N_O_N(root, p.val, res1, new ArrayList<>()); // TC - O(N)
        lowest_common_ancestor_O_N_O_N(root, q.val, res2, new ArrayList<>()); // TC - O(N)


        TreeNode ans = null;

        for(int i=0; i<Math.min(res1.size(), res2.size()); i++){ // TC - O(N)
            if(res1.get(i).val == res2.get(i).val)
                ans = res1.get(i);
            else
                break;
        }

        return ans;
    }

    public static void lowest_common_ancestor_O_N_O_N(TreeNode root, int target, List<TreeNode> res, List<TreeNode> curr ){
        if(root == null)
            return;

        if(root.val == target){
            curr.add(root);
            res.addAll(curr);
            return;
        }

        curr.add(root);

        lowest_common_ancestor_O_N_O_N(root.left, target, res, curr);
        lowest_common_ancestor_O_N_O_N(root.right, target, res, curr);

        curr.remove(root);
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
