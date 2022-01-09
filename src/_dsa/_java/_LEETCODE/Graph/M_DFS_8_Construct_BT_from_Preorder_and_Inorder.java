package _dsa._java._LEETCODE.Graph;
import java.util.*;

// Question: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// RESPONSE: SOLVED, Time-O(n^2)
// OPTIMIZE: Time-O(n), using HashMap

public class M_DFS_8_Construct_BT_from_Preorder_and_Inorder {

	public static void main(String[] args) {
		int preorder[] = {3,9,20,15,7};
		int inorder[] = {9,3,15,20,7};
		
		TreeNode root = buildTree(preorder, inorder);
		
		printTree(root);
	}
   
	static int index = 0;
	static Map<Integer, Integer> mp = new HashMap<>();
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(-1);

//        System.out.println("My Approach: Time-O(n^2)");
//        return createBT(inorder, preorder, root, 0, inorder.length);
        
        // Mapping the index of node from inOrder 
        for(int i=0; i<inorder.length; i++)
            mp.put(inorder[i], i);
        
        System.out.println("Optimized: Time-O(n)");
        return optimize(inorder, preorder, root, 0, inorder.length);
    }
    
    
    ////////////////////
    // MY APPROACH - without HashMap
    ////////////////////
    public static TreeNode createBT(int[] in, int[] pre, TreeNode node, int low, int high){
        if(index>=in.length || low>high)
            return null;
        
        node = new TreeNode(pre[index]);

        int val = -10;
        
        for(int i=low; i<=high; i++){
            if(in[i] == pre[index]){
                val = i;
                break;
            }
        }
        
        index++;
        
        if(val != -10){
            node.left = createBT(in, pre, node.left, low, val-1);
            node.right = createBT(in, pre, node.right, val+1, high);
        }
        
        return node;
    }
    
    
    
	////////////////////////////////////////
	// OPTIMIZED o(n)- with HashMap 
    ////////////////////////////////////////
    
    public static TreeNode optimize(int[] in, int[] pre, TreeNode node, int low, int high) {
    	if(index>=in.length || low>high)
            return null;
        
        node = new TreeNode(pre[index]);

        int val = -10;
        
        // Getting index from INORDER stored in HASHMAP
        val = mp.get(pre[index]);
        
        index++;
        
        if(val != -10){
            node.left = createBT(in, pre, node.left, low, val-1);
            node.right = createBT(in, pre, node.right, val+1, high);
        }
        
        return node;
    }
    
    public static void printTree(TreeNode node){
    	if(node == null)
    		return;
    	
    	System.out.print(node.val + " ");
    	printTree(node.left);
    	printTree(node.right);
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
