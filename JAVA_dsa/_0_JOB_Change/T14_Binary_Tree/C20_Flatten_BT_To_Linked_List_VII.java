package _dsa._0_JOB_Change.T14_Binary_Tree;

public class C20_Flatten_BT_To_Linked_List_VII {
    // Ques: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    // Logic: we will create bottom-up fashion
    // once a root is traveled, we mark its left = null
    // and right = prev (last used root)

    // so when we get last root & its prev = null
    // last_root.left = null
    // last_root.right = prev

    // prev = last_root

    public static void main(String[] args) {

    }

    private TreeNode prev = null;

    public void flatten_postOrder(TreeNode root) {
        if (root == null)
            return;

        flatten_postOrder(root.right);
        flatten_postOrder(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
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
