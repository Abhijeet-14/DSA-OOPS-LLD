package _dsa._java._LEETCODE.Graph;

// QUESTION: https://leetcode.com/problems/maximum-depth-of-binary-tree/

// RESPONSE: SOLVED, With help of previous questions
// OPTIMIZE: DFS METHOD

public class M_DFS_4_maximum_depth_of_binary_tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
	
		System.out.println("OPTIMIZE(DFS Method): with help of previous quesitons!");
		int val = maxDepth(root);
		
		System.out.println(val);
	}
	
	static int max = 0;
	
    public static int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        
        int count = 1;
        dfs(root, count);

        return max;
    }
    
    public static void dfs(TreeNode node, int count){
        if(node == null) 
            return;
        
        if(node.left == null && node.right == null){
        	// check the maximum bw max and count of current line
            max = Math.max(max, count);
        }
        else{
        	// when we go 1 line deep, we increase count;
            count++;
            dfs(node.left, count);
            dfs(node.right, count);
        }
        
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
