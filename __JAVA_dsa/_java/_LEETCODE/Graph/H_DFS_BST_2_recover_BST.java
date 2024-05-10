package _dsa._java._LEETCODE.Graph;
import java.util.*;

// Question: https://leetcode.com/problems/recover-binary-search-tree/

// RESPONSE: NOT SOLVED!!
// OPTIMIZE: O(1)

public class H_DFS_BST_2_recover_BST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);	
		root.left =  new TreeNode(4);
		root.right =  new TreeNode(1);
		
		System.out.println("MY APPROACH: Unable to solved");
		
		System.out.println("\nBASIC APPROACH O(nLogn), O(n):");
			basicApproach(root);
		
		System.out.println("\n\nOPTIMIZED: O(n) time");
		System.out.println("\tIn INORDER nodes are in increasing sequence."
						 + "\n\tSo if CURRENT node is smaller than PREVIOUS node, Violating BST"
								 + "\n\t\tFor first violation, TEMP = root, 1st node"
								 + "\n\t\tTEMP1 = root, 2nd node, change over tree"
						 + "\n\tStore PREVIOUS = CURRENT,"
						 + "\n\tfinally we get TEMP & TEMP1 are 2 node to be swap");

		System.out.print("UNRECOVERED: ");
		printTree(root);
			recoverTree(root);
		
		System.out.print("\nRECOVERED: ");
		printTree(root);
	}

	////////////////////
	// BASIC APPROACH
	////////////////////
	public static void basicApproach(TreeNode root) {
		System.out.println("\t InOrder gives SORTED BSTREE, so our tree has only 2 unsorted element,"
							+"\t Therefore: just sort the TREE after storing it");
		
		List<TreeNode> val = new ArrayList<>();
		
		// Store tree in LIST<>
		inO(root, val);
		
		System.out.print("UNRECOVERED: ");
		for(TreeNode v: val)
			System.out.print(v.val + " ");
		
		// Sort the LIST<>
		Collections.sort(val, new SortTree());
		
		System.out.print("\nRECOVERED: ");
		for(TreeNode v: val)
			System.out.print(v.val + " ");
		
	}
	
	public static void inO(TreeNode node, List<TreeNode> val) {
		if(node == null)
			return;
		
		inO(node.left, val);
		val.add(node);
		inO(node.right, val);
	}
	
	
	////////////////////////////
	// OPTIMIZED:
	////////////////////////////
	static TreeNode temp = null;
	static TreeNode temp1 = null;
	static TreeNode prev = null;

	  
	// In INORDER nodes are in increasing sequence.
	// So if CURRENT node is smaller than PREVIOUS node, Violating BST
			// For first violation, TEMP = root, 1st node
			// TEMP1 = root, 2nd node, change over tree
	// Store PREVIOUS = CURRENT,

	// finally we get TEMP & TEMP1 are 2 node to be swap
    public static void recoverTree(TreeNode root) {
        
        inorder(root);

        // SWAP btw temp1 & temp
        int t = temp.val;
        temp.val = temp1.val;
        temp1.val = t;
    }
    
    public static void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        
        // node is smaller than previous node, it's violating the BST rule. 
        if (prev != null && root.val < prev.val) {
        	// First violation
            if (temp == null) 
                temp = prev; // FIRST node to SWAP!
            
         // second node to SWAP!
            temp1 = root;  // it change ACC to the Tree.
        }

        // Mark this node as previous 
        prev = root; 

        inorder(root.right);
    }
    
    
    public static void printTree(TreeNode node) {
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
	 
	public static class SortTree implements Comparator<TreeNode>{

		public int compare(TreeNode n1, TreeNode n2) {
			return n1.val-n2.val;
		}
	}
}