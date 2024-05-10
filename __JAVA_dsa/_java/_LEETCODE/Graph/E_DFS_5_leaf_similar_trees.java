package _dsa._java._LEETCODE.Graph;
import java.util.*;

// Question: https://leetcode.com/problems/leaf-similar-trees/submissions/

// Response: Solved, help of previous question
// OPTIMIZE: DFS method

public class E_DFS_5_leaf_similar_trees {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(1);
		
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		
		boolean is = leafSimilar(root1, root2);
		
		System.out.println("MY APPRAOCH: OPTIMIZED, Time-O(n1+n2)");
		System.out.println(is);
	}
	
	 public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        
        dfs(root1, val1);
        dfs(root2, val2);
        
        if(val1.size() != val2.size())
            return false;
        
        for(int i=0; i<val1.size(); i++){
            if(val1.get(i) != val2.get(i))
                return false;
        }
        
        return true;
        
    }
    
    public static void dfs(TreeNode node, List<Integer> lst){
        if(node == null)
            return;
        
        if(node.left == null && node.right == null)
            lst.add(node.val);
        else{
            dfs(node.left, lst);
            dfs(node.right, lst);
        }
    }	

    public static class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode() {}
    	public TreeNode(int _val) { val = _val;}
    	public TreeNode(int _val, TreeNode _left, TreeNode _right) { 
    		val = _val;
    		left = _left;
    		right = _right;
    	}
    }
}
