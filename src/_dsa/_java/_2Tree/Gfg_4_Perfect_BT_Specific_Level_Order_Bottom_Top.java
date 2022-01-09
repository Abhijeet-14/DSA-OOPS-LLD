package _dsa._java._2Tree;

//Java program for special level order traversal 

import java.util.LinkedList; 
import java.util.Queue;
import java.util.Stack;

/* Class containing left and right child of current  
node and key value*/



public class Gfg_4_Perfect_BT_Specific_Level_Order_Bottom_Top {

	static class Node
	{ 
		int data; 
		Node left, right; 
		
		public Node(int item)  
		{ 
			data = item; 
			left = right = null; 
		}
	} 
	
	Node root; 

	/* Given a perfect binary tree, print its nodes in specific 
	  level order */
	static void printSpecificLevelOrder_BT(Node node)  
	{ 
	   if (node == null) 
	       return; 
	   
	   // Do anything more if there are nodes at next level in 
	   // given perfect Binary Tree 
	   if (node.left.left == null) 
	       return; 
	
	   // Create a queue and enqueue left and right children of root 
	   Queue<Node> q = new LinkedList<Node>();
	   Stack<Node> s = new Stack<>();
	   
	   q.add(node.right); 
	   q.add(node.left); 
	
	   s.add(node);
	   s.add(node.left);
	   s.add(node.right);
	   
	   // We process two nodes at a time, so we need two variables 
	   // to store two front items of queue 
	   Node first = null, second = null; 
	
	   // traversal loop 
	   while (!q.isEmpty())  
	   { 
	       // Pop two items from queue 
	       first = q.peek(); 
	       q.remove(); 
	       second = q.peek(); 
	       q.remove(); 
	       
	       
	
	       s.push(first.left); 
	       s.push(second.right); 
	       s.push(first.right); 
	       s.push(second.left);
	       
	       // If first and second have grandchildren, enqueue them 
	       // in reverse order 
	       if (first.left.left != null)  
	       { 
	           q.add(first.left); 
	           q.add(second.right); 
	           q.add(first.right); 
	           q.add(second.left);
	           
	          
	       } 
	   } 
	   
	   while(!s.isEmpty()) {
		   Node curr = s.peek();
		   System.out.print(curr.data + " ");
		   s.pop();
	   }
	   
	   System.out.println();
	}
	
	
	
	
	static void specifLevelOrder_LineByLine(Node node) {
		if(node == null)
			return;
			
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		
		s.add(node);
		s.add(null);
		
		if(node.left.left == null)
			return;
		
		q.add(node.right);
		q.add(node.left);
		q.add(null);
		q.add(null);
		
		s.add(node.right);
		s.add(node.left);
		s.add(null);
		
		Node first, second, temp;
		// 3 2 n n 6 5 7 4 n n 12 11 13 10 14 9 15 8 n n
		while(!q.isEmpty()) {
			
			temp = q.peek(); // 3 // n // 6 // 7  // n // 12 

			if(temp == null) {
				if(!q.isEmpty()) {
					s.push(null);
					q.add(null);
					q.remove();
				}
			}
			else{
				System.out.println(q.peek().data);
				first = q.peek();	// 3 // 6	// 7
				q.remove();	
				second = q.peek();	// 2 // 5	// 4
				q.remove();


				s.push(first.left);		// 6 // 12 // 14
				s.push(second.right);	// 5 // 11	// 9
				s.push(first.right);	// 7 // 13	// 15
				s.push(second.left);    // 4 // 10	// 8
				
				if(first.left.left != null) {
					q.add(first.left); 		// 6 // 12
					q.add(second.right);	// 5 // 11	
					q.add(first.right);		// 7 // 13
					q.add(first.left);		// 4 // 10
				}
			}
		}
		
		System.out.println();
		
		while(!s.isEmpty()) {
		   Node curr = s.peek();
		   
		   if(curr == null)
			   System.out.println();
		   else
			   System.out.print(curr.data + " ");

		   s.pop();
	   }
	   
	   System.out.println();
		
	}
	// Driver program to test for above functions 
	public static void main(String args[])  
	{ 
	    
	   Node root = new Node(1); 
	   root.left = new Node(2); 
	   root.right = new Node(3); 
	
	   root.left.left = new Node(4); 
	   root.left.right = new Node(5);
	   root.right.left = new Node(6); 
	   root.right.right = new Node(7); 
	
	   root.left.left.left = new Node(8); 
	   root.left.left.right = new Node(9); 
	   root.left.right.left = new Node(10); 
	   root.left.right.right = new Node(11); 
	   root.right.left.left = new Node(12); 
	   root.right.left.right = new Node(13); 
	   root.right.right.left = new Node(14); 
	   root.right.right.right = new Node(15); 
	
	   root.left.left.left.left = new Node(16); 
	   root.left.left.left.right = new Node(17); 
	   root.left.left.right.left = new Node(18); 
	   root.left.left.right.right = new Node(19); 
	   root.left.right.left.left = new Node(20); 
	   root.left.right.left.right = new Node(21); 
	   root.left.right.right.left = new Node(22); 
	   root.left.right.right.right = new Node(23); 
	   root.right.left.left.left = new Node(24); 
	   root.right.left.left.right = new Node(25); 
	   root.right.left.right.left = new Node(26); 
	   root.right.left.right.right = new Node(27); 
	   root.right.right.left.left = new Node(28); 
	   root.right.right.left.right = new Node(29); 
	   root.right.right.right.left = new Node(30); 
	   root.right.right.right.right = new Node(31); 
	
	   
	   System.out.println("Specific Level Order traversal of binary in O(n) time  " 
	                                                       +"tree is "); 
	   printSpecificLevelOrder_BT(root);
	   

	   System.out.println("Specific Level Order traversal of BT Line By Line in O(n) time  " 
			   +"tree is "); 
	   
	   specifLevelOrder_LineByLine(root);
	} 
} 

//This code has been contributed by Mayank Jaiswal