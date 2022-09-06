package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C2_Level_Order_Traversal {
    // Question: https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right.left = new TreeNode(3);

        List<List<Integer>> ans = levelOrder(root); // TC - O(N), AS - O(N)
        System.out.println(ans);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        level_order(root, ans);
        return ans;
    }

    public static void level_order(TreeNode root, List<List<Integer>> ans){
        if(root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        List<Integer> _ans = new ArrayList<>();
        boolean isTrue = false;

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp != null){
                isTrue = true;
                _ans.add(temp.val);

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }

            }
            else{

                if(isTrue == true){
                    ans.add(_ans);
                    q.add(temp);
                }

                isTrue = false;
                _ans = new ArrayList<>();
            }

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
