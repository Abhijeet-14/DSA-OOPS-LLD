package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C1_BT_pre_order_traversal {
    // Question: https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> arr = preorderTraversal(root);
        System.out.println(arr);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preOrder(root, ans);
        return ans;
    }
    // PreOrder - NLR

    public static void preOrder(TreeNode root, List<Integer> ans){
        if(root == null)
            return;
        else{
            ans.add(root.val);
            preOrder(root.left, ans);
            preOrder(root.right, ans);
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
