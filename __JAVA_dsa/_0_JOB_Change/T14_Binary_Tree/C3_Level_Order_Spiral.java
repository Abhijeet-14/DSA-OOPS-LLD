package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C3_Level_Order_Spiral {
    // Question: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        level_order_spiral_2_stack(root, ans);
        return ans;
    }

    public static void level_order_spiral_2_stack(TreeNode root, List<List<Integer>> ans) {
        if(root == null)
            return;
        Stack<TreeNode> s_left = new Stack<>();
        Stack<TreeNode> s_right = new Stack<>();

        s_left.push(root);
        List<Integer> _ans = new ArrayList<>();

        while(!s_left.isEmpty() || !s_right.isEmpty()){
            while(!s_left.isEmpty()){
                TreeNode curr = s_left.pop();
                _ans.add(curr.val);
                if(curr.left!=null)
                    s_right.push(curr.left);
                if(curr.right!=null)
                    s_right.push(curr.right);
            }
            if(!_ans.isEmpty())
                ans.add(_ans);
            _ans = new ArrayList<>();

            while(!s_right.isEmpty()){
                TreeNode curr = s_right.pop();
                _ans.add(curr.val);
                if(curr.right!=null)
                    s_left.push(curr.right);
                if(curr.left!=null)
                    s_left.push(curr.left);
            }
            if(!_ans.isEmpty())
                ans.add(_ans);
            _ans = new ArrayList<>();
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
