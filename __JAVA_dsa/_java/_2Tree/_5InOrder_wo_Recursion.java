package _dsa._java._2Tree;

import java.util.Stack;

// _5InOrder_w/o_Recursion:

public class _5InOrder_wo_Recursion {

	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	static void inOrder_S(Node root) {
		
		if( root == null) 
			return;
		
		Stack<Node> s = new Stack<>();
		Node curr = root;
		
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			
			Node popped = s.pop();
			
			System.out.print(popped.data + " ");
			
			curr = popped.right;
		}
		
		// to change the line!
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right = new Node(3);
		root.right.right = new Node(6);
		root.right.left = new Node(7);
		
		inOrder_S(root);
		
		inOrder_S(root.left);
		
		inOrder_S(root.right);
		
		System.out.println("Time - O(n)");
		
	}

}
