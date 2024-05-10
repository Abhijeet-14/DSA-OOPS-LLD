package _dsa._java._2Tree;


public class _6InOrder_wo_R_wo_Stack {

	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	static void inOrder_Morris_Traversal(Node root) {
		if(root == null) 
			return;
		
		Node curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			else {
				/*Find inOrder Predecessor of CURRENT Node*/
				Node pre = curr.left;
				while(pre.right != null && pre.right != curr) 
					pre = pre.right;
				
				/*Make Current as Right Child of its predecessor!!*/
				if(pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				}
				else {
					pre.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
		// to start from new Line!!
		System.out.println();
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right = new Node(3);
		root.right.right = new Node(6);
		
		inOrder_Morris_Traversal(root);
		
		inOrder_Morris_Traversal(root.left);
		inOrder_Morris_Traversal(root.right);
		
		System.out.println("\nTime - O(n)" +
				"\n  But if we see, we notice that Every Edge of the TREE is traversed at most 2 times." +
				"\n  And in the WROST case, the same number of Extra edges(as input tree) are created and removed");
		
	}

}
