package _dsa._java._2Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Gfg_6_Construct_CompleteBT_from_its_LinkedList_Representation {

	static class LLNode{
		int data;
		LLNode next;
		
		LLNode(int data){
			this.data=data;
			this.next = null; 
		}
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left = null; 
			this.right = null; 
		}
	}
	
	static void btFromLL(Node root, LLNode head) {
		if(head == null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		
		root = new Node(head.data);
		
		q.add(root);
				
		LLNode curr = head;
		
		while(curr != null && !q.isEmpty()) {
			
			Node temp = q.peek();
			q.remove();
			
			if(curr.next != null) {
				temp.left = new Node(curr.next.data);
				q.add(temp.left);
				curr = curr.next;
			}
			if(curr.next != null) {
				temp.right = new Node(curr.next.data);
				q.add(temp.right);
				curr = curr.next;
			}
			
		}
		
		inOrder(root);
	}
	
	static void inOrder(Node node) {
		if(node == null) 
			return;
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	public static void main(String[] args) {
		
		Node root = null;

		LLNode head = new LLNode(10);
		
		head.next  = new LLNode(12);
		head.next.next = new LLNode(15);
		head.next.next.next  = new LLNode(25);
		head.next.next.next.next  = new LLNode(30);
		head.next.next.next.next.next  = new LLNode(35);
		head.next.next.next.next.next.next  = new LLNode(40);
		head.next.next.next.next.next.next.next  = new LLNode(45);
		head.next.next.next.next.next.next.next.next  = new LLNode(50);
		head.next.next.next.next.next.next.next.next.next  = new LLNode(55);
		
		btFromLL(root, head);
	}

}
