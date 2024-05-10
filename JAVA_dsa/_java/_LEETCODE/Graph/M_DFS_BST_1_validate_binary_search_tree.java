package _dsa._java._LEETCODE.Graph;


// Question: https://leetcode.com/problems/validate-binary-search-tree/

// RESPONSE: SOLVED, OPTIMIZED!! 
//			TC - O(N), SC - O(N)
public class M_DFS_BST_1_validate_binary_search_tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left =  new TreeNode(1);
		root.right =  new TreeNode(4);
		root.right.left =  new TreeNode(3);
		root.right.right =  new TreeNode(6);
		
		System.out.print("MY APPROACH: OPTIMIZED, 100% faster, ");
		System.out.println("TC - O(N), SC - O(N)");
		System.out.println(isValidBST(root));
	}
	
	 
    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        
        return isBST(root, null, null);
    }
    
    public static boolean isBST(TreeNode node, Integer upper, Integer lower){
        if(node == null)
            return true;
        
        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper))  
            return false;

        if(node.left != null && node.left.val >= node.val) 
               return false;

        if(node.right != null && node.right.val <= node.val) 
               return false;

        return (isBST(node.left, node.val, lower) && isBST(node.right, upper, node.val));
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

