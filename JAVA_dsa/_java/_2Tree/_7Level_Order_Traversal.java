package _dsa._java._2Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _7Level_Order_Traversal {
	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	// Using Queue!!
	static void levelOrder(Node root) {
		if(root == null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node temp;
		
		while(!q.isEmpty()) {
			temp = q.peek();

			System.out.print(temp.data + " ");
			
			q.remove();
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
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
		
		levelOrder(root);
		levelOrder(root.left);
		
		System.out.println("Time - O(n)");
		

	}

}
