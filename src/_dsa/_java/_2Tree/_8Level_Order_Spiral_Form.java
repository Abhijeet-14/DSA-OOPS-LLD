package _dsa._java._2Tree;

import java.util.Stack;

public class _8Level_Order_Spiral_Form {
	
	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	// Here We have to use 2 Stacks... 1 for L->R direction & other for R->L direction
	static void levelOrder_Spiral(Node root) {
		if(root==null)
			return;
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		s1.push(root);
		Node curr;

		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				curr = s1.peek();
				
				s1.pop();
				
				System.out.print(curr.data + " ");
				
				if(curr.right != null)
					s2.push(curr.right);
				
				if(curr.left != null)
					s2.push(curr.left);
			}
			
			while(!s2.isEmpty()) {
				curr = s2.peek();
				
				s2.pop();
				
				System.out.print(curr.data + " ");
				
				if(curr.left != null)
					s1.push(curr.left);
				
				if(curr.right != null)
					s1.push(curr.right);
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {


		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		levelOrder_Spiral(root);
		
		System.out.println("Time - O(n)");
		System.out.println("  It take O(n) time and O(n) extra space!!");

	}

}
