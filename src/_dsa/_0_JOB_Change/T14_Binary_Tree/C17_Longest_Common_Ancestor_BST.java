package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C17_Longest_Common_Ancestor_BST {
    // Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> r1 = new ArrayList<>();
        List<TreeNode> r2 = new ArrayList<>();

        solve(root, r1, p, new ArrayList<>());
        solve(root, r2, q, new ArrayList<>());

        TreeNode ans = null;
        for(int i=0; i<Math.min(r1.size(), r2.size()); i++){
            if(r1.get(i).val == r2.get(i).val)
                ans = r1.get(i);
            else
                break;
        }

        return ans;
    }

    public static void solve(TreeNode root, List<TreeNode> r, TreeNode x, List<TreeNode> curr){
        if(root == null)
            return;

        if(root.val == x.val)
        {
            curr.add(root);
            r.addAll(curr);
            return;
        }

        curr.add(root);

        if(x.val > root.val )
            solve(root.right, r, x, curr);
        else
            solve(root.left, r, x, curr);

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
