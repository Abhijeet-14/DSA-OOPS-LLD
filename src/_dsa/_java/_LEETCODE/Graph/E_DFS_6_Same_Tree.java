package _dsa._java._LEETCODE.Graph;
import java.util.*;


// Question: https://leetcode.com/problems/same-tree/

// Response: SOLVED!, OPTIMIZED! 
//			O(n) TIME, O(Logn) SPACE best case, O(n) SPACE worst case

public class E_DFS_6_Same_Tree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(1);
		
		p.left = new TreeNode(2);
		q.left = new TreeNode(2);
		
		p.right = new TreeNode(3);
		q.right = new TreeNode(2);
		
		System.out.println("My Approach - Optimized, O(n) time");
		boolean isSame = isSameTree(p, q);

//		System.out.println("Iterative Approach: ");
//        boolean isSame =  iteratApproach(p, q);
        
		System.out.println(isSame);
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        return inOrder(p, q);  
    }
    
    public static boolean inOrder(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        
        if(p == null || q == null)
            return false;

         if(p.val != q.val) 
            return false;
        
        return inOrder(p.left, q.left) && inOrder(p.right, q.right);
    }

    public static boolean iteratApproach(TreeNode p, TreeNode q) {

        Queue<TreeNode> qu = new LinkedList<>();
        
        if(p == null && q == null)
        	return true;
        if(p == null || q == null)
        	return false;
        if( p!=null && q != null) {
        	qu.add(p);
        	qu.add(q);
        }
        
        while(!qu.isEmpty()) {
        	TreeNode first = qu.poll();
        	TreeNode second = qu.poll();
        	
        	if (first == null && second == null)
                continue;
            if (first == null || second == null)
                return false;
            if (first.val != second.val)
                return false;
            
            qu.offer(first.left);
            qu.offer(second.left);
            qu.offer(first.right);
            qu.offer(second.right);
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
