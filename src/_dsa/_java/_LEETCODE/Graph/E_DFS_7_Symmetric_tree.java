package _dsa._java._LEETCODE.Graph;
import java.util.*;


// Question: https://leetcode.com/problems/symmetric-tree/

// RESPONSE: SOLVED!, Optimized(INORDER)

public class E_DFS_7_Symmetric_tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		
		System.out.println("My Approach: Optimized, TIME-O(n), SPACE-O(Logn) or O(n)");
		
		boolean is = isSymmetric(root);
		
		System.out.println(is);
		
	}
	
	public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        System.out.println("Recursive: ");
        return inOrder(root.left, root.right);
        
//        System.out.println("Iterative: ");
//        return iterativeApp(root.left, root.right);
    }
	
	 public static boolean inOrder(TreeNode p, TreeNode q){
       if(p == null && q == null)
           return true;
      
       if(p == null || q == null)
           return false;

        if(p.val != q.val) 
           return false;
      
       return inOrder(p.left, q.right) && inOrder(p.right, q.left);
   }

	public static boolean iterativeApp(TreeNode p, TreeNode q){

        if(p == null && q == null)
            return true;
        
        if(p == null || q == null)
            return false;

        Queue<TreeNode> qu1 = new LinkedList<>();
        Queue<TreeNode> qu2 = new LinkedList<>();
        
        if(p != null && q != null){
            qu1.add(p);
            qu2.add(q);
        }
        

        while(!qu1.isEmpty() && !qu2.isEmpty()){
            TreeNode t1 = qu1.poll();
            TreeNode t2 = qu2.poll();
            
            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
          
            // L-R
            qu1.add(t1.left);
            qu1.add(t1.right);
            
            // R-L            
            qu2.add(t2.right);
            qu2.add(t2.left);
        }
        
        return true;
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
