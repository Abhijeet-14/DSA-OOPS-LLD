package _dsa._java._2Tree;


import java.util.Scanner;

public class _1BinaryTree {
	Node root;
	
	Scanner sc = new Scanner(System.in); 

	public Node create() {
		
		int x;

		if(root == null) {
			System.out.print("Enter the Root Node Value {-1 to enter Null Value}: ");
			x = sc.nextInt();
		
			if(x == -1) {
				return null;
			}
		
			root = new Node(x);
			System.out.println("\nEnter left Node of " + root.data);
			root.left = create();
			System.out.println("\nEnter right Node of " + root.data);
			root.right = create();
			
			return root;
		}
		
		
		System.out.print("Enter the Node Value {-1 to enter Null Value}: ");
		x = sc.nextInt();
		
		System.out.println();
		
		if(x == -1) {
			return null;
		}
		
		Node newNode = new Node(x);
		
		System.out.println("Enter left Node of " + newNode.data);
		newNode.left = create();
		System.out.println("Enter right Node of " + newNode.data);
		newNode.right = create();
		
		return newNode;
		
	}
	
	
	
// TRAVERSAL:
	
	// INORDER
	public void InOrder(Node rootNode){

		if (rootNode == null) {
			return;
		}
		
		InOrder(rootNode.left);
		System.out.print(rootNode.data + " ");
		InOrder(rootNode.right);
	}
	
	//PreOrder
	public void PreOrder(Node rootNode){
		
		if (rootNode == null) {
			return;
		}
		
		System.out.print(rootNode.data + " ");
		PreOrder(rootNode.left);
		PreOrder(rootNode.right);
	}
	
	// PostOrder
	public void PostOrder(Node rootNode){
		
		if (rootNode == null) {
			return;
		}
		
		PostOrder(rootNode.left);
		PostOrder(rootNode.right);
		System.out.print(rootNode.data + " ");
	}
	
	
// Node Class
	public static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
