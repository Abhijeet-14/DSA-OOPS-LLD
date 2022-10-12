package _dsa._0_JOB_Change.T14_Binary_Tree.Construction_Conversion;

import java.util.HashMap;
import java.util.Map;

public class C2_Convert_BT_From_Inorder_PostOrder {
    // Ques: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    static Map<Integer, Integer> map;
    public static void main(String[] args)
    {
        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};

        map = new HashMap<>();

        int start = 0;
        int end = postorder.length - 1;

        for(int i=0; i<end+1; i++)
            map.put(inorder[i], i);

        index = 0;

        TreeNode root;
        if(inorder.length == 1 && inorder[0] == -1){
            root = new TreeNode(-1);
        }
        else {
            map = new HashMap<>();
            for (int j = 0; j < inorder.length; j++)
                map.put(inorder[j], j);

            root = solve(inorder, postorder, start, end);
        }
        printInorder(root);
    }

    static int index;

    static TreeNode solve(int[] inorder, int[] postorder, int start, int end){
        if(start>end)
            return null;

        int pIdx = postorder.length - index - 1;

        if(pIdx < 0 || pIdx >= postorder.length)
            return null;

        int curr_val = postorder[postorder.length - index - 1];

        int idx = findNode(curr_val);

        TreeNode curr_root = null;
        if(idx != -1){
            index++;

            curr_root = new TreeNode(curr_val);
            curr_root.right = solve(inorder, postorder, idx+1, end);
            curr_root.left = solve(inorder, postorder, start, idx-1);
        }

        return curr_root;
    }

    static int findNode(int X){
        if(map.containsKey(X))
            return map.get(X);
        return -1;
    }
    static void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static class TreeNode
    {
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
