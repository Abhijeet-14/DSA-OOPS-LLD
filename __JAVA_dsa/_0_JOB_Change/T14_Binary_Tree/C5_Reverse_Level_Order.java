package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C5_Reverse_Level_Order {
    // Question: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> ans_stack = new Stack<>();
        List<List<Integer>> ans_list = new ArrayList<>();

        level_order_Reversing_List(root, ans_list); // O(N) - method 1
        level_order_Use_Stack_Ans(root, ans_stack); // O(N) - method 2

        List<List<Integer>> final_ans_stack = new ArrayList<>();

         while(!ans_stack.isEmpty())
             final_ans_stack.add(ans_stack.pop());


        Collections.reverse(ans_list);;
        return ans_list;

//        return final_ans_stack;

    }

    public static void level_order_Reversing_List(TreeNode root, List<List<Integer>> ans){
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

    public static void level_order_Use_Stack_Ans(TreeNode root, Stack<List<Integer>> ans){
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
