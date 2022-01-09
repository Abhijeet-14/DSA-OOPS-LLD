package _dsa._java._2Tree;

//Java program for special level order traversal 

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.ArrayList; 

/* Class containing left and right child of current  
node and key value*/

class Gfg_3_Perfect_BT_Specific_Level_Order_Top_Bottom 
{ 
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
 static void printSpecificLevelOrder(Node node)  
 { 
     if (node == null) 
         return; 

     // Let us print root and next level first 
     System.out.print(node.data); 

     //  Since it is perfect Binary Tree, right does not need to check.
     if (node.left != null) 
         System.out.print(" " + node.left.data + " " + node.right.data); 

     // Do anything more if there are nodes at next level in 
     // given perfect Binary Tree 
     if (node.left.left == null) 
         return; 

     // Create a queue and enqueue left and right children of root 
     Queue<Node> q = new LinkedList<Node>(); 
     q.add(node.left); 
     q.add(node.right); 

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

         // Print children of first and second in reverse order 
         System.out.print(" " + first.left.data + " " +second.right.data); 
         System.out.print(" " + first.right.data + " " +second.left.data); 

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
     System.out.println();
 }
 
 
 // using Queue & ArrayList
 static void specifcLevelOrder(Node node) {
	 
	 if(node == null)
		 return;
	 
	 Queue<Node> q = new LinkedList<>();
	 ArrayList<Integer> a = new ArrayList<>();
	 
	 q.add(node);
	 q.add(null);
	 
	 System.out.print(node.data);
	 
	 int j = 0;
	 Node temp;
	 
	 while(!q.isEmpty()) {
		 temp = q.peek();
		 q.remove();
		 
		 if(temp ==  null) {
			 q.add(null);
			 for(int i = a.size() - 1; i>j; i-- ) {
				 System.out.print(" " + a.get(j) + " " + a.get(i));
				 j++;
			 }
			 j =a.size();
		 }
		 else {
			 if(temp.left != null)
				 q.add(temp.left);
			 if(temp.right != null)
				 q.add(temp.right);
			 
			 a.add(temp.data);
		 }
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
     printSpecificLevelOrder(root);
     
     
     System.out.println("Specific Level Order traversal of binary in O(n^2) time " 
    		 											+"tree is "); 
     specifcLevelOrder(root);
     
     // this "specifcLevelOrder(root)" takes a lot of time 
     // so that it won't execute the Next Line!
     System.out.println("abc");
 } 
} 

//This code has been contributed by Mayank Jaiswal