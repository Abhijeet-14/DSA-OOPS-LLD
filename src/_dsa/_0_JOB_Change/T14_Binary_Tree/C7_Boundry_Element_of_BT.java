package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C7_Boundry_Element_of_BT {
    public static void main(String[] args) {
        // Logic
        // we need to travel ANTI-CLOCKWISE,
        // 1. take all left boundary [except leaf Node]
        // 2. take all leaf Node
        // 3. take all right boundary [except left Node]

        // How to take all left boundary:
        //      start from root -> and take all left-element
        //      if left = null, take right
        //      if left & right both null -> leaf node [can't take this]

        // all leaf node:
        //      travel in_order
        //      if left & right both are null => leaf node
        //      take this node

        // How to take all right boundary:
        //      start root.right -> and take all right-element
        //      if right = null, take left
        //      if left & right both null -> leaf node [can't take this]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> ans = new ArrayList<>();
        add_left_boundary(root, ans);
        add_leaves(root, ans);
        add_right_boundary(root, ans);

        printArr(ans);
    }



    public static boolean is_leaf(TreeNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }

    public static void add_left_boundary(TreeNode root, List<Integer> ans){
        root = root.left;
        while(root!=null){
            if(!is_leaf(root))
                ans.add(root.val);

            if(root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    public static void add_right_boundary(TreeNode root, List<Integer> ans){
        Stack<Integer> s = new Stack<>();

        root = root.right;
        while(root!=null){
            if(!is_leaf(root))
                s.add(root.val);

            if(root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        while(!s.isEmpty()){
            ans.add(s.peek());
            s.pop();
        }
    }

    public static void add_leaves(TreeNode root, List<Integer> ans){
        // In_Order traversal
        if (root == null) {
            return;
        }

        if (is_leaf(root)) {
            ans.add(root.val); // just store leaf nodes
            return;
        }

        add_leaves(root.left, ans);
        add_leaves(root.right, ans);
    }

    private static void printArr(List<Integer> ans) {
        System.out.print("[");
        for(int val: ans)
            System.out.print(val + ", ");
        System.out.println("]");
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
