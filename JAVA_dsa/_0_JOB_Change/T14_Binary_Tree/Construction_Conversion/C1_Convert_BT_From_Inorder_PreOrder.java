package _dsa._0_JOB_Change.T14_Binary_Tree.Construction_Conversion;

import java.util.HashMap;
import java.util.Map;

public class C1_Convert_BT_From_Inorder_PreOrder {
    // Ques: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    static Map<Integer, Integer> map;
    public static void main(String[] args)
    {
        int inOrder[] = {3,9,20,15,7};
        int preOrder[] = {9,3,15,20,7};

        int pS = 0;
        int pE = preOrder.length;


        TreeNode root;
        if(inOrder.length == 1 && inOrder[0] == -1){
            root = new TreeNode(-1);
        }
        else {
            map = new HashMap<>();
            for (int j = 0; j < inOrder.length; j++)
                map.put(inOrder[j], j);

            i = 0;
            root = solve(preOrder, inOrder, pS, pE - 1);
        }
        printInorder(root);
    }

    static int i;

    static TreeNode solve(int[] preOrder, int[] inOrder, int pS, int pE)
    {
        if(pS>pE)
            return null;

        if(i >= inOrder.length)
            return null;

        int idx = findNode(preOrder[i]);

        TreeNode curr_root = null;
        if(idx != -1) {
            i++;

            curr_root = new TreeNode(inOrder[idx]);

            curr_root.left = solve(preOrder, inOrder, pS, idx-1);
            curr_root.right = solve(preOrder, inOrder, idx+1, pE);
        }

        return curr_root;
    }

    static int findNode(int x)
    {

        if(map.containsKey(x))
            return map.get(x);

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
