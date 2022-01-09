package _dsa._java._LEETCODE.Graph;

// Question: https://leetcode.com/problems/range-sum-of-bst/

// Response: SOLVED!!

public class E_DFS_1_Range_sum_of_bst {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		
		int L = 7;
		int R = 15;
		
		System.out.println( rangeSumBST(root, L, R) );
	}
	
	public static int rangeSumBST(TreeNode root, int L, int R) {
		// i -> 2i+1, 2i+2
	    if(root == null) 
	    	return 0;

        int sum = dfs(root, L, R);
        
        return sum;
    }
	    
    public static int dfs(TreeNode root, int L, int R){
        if(root == null) 
            return 0;
        
        else if(root.val >=L && root.val<=R)
            return root.val + dfs(root.left, L, R) + dfs(root.right, L, R);

        else if(root.val <L)
            return dfs(root.right, L, R);
            
        return dfs(root.left, L, R);
    }

    public static class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode() {}
    	
    	public TreeNode(int val) {this.val = val;}
    	
    	public TreeNode(int val, TreeNode left, TreeNode right) {
    		this.val = val;
    		this.left = left;
    		this.right = right;
    	}
    }
}
