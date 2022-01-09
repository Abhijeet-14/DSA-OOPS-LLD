package _dsa._java._2Tree;

public class _3BinarySearchTree {
	
	Node root;

// refer to ROOT!
	public Node toRoot() {
		if(root == null) {
			System.out.println("Tree is Empty!");
			return null;
		}	
		
		return root;
	}
	
	
// TREE-INSERT
	public void insert(int Data) {
		if(Data == -1) {
			System.out.println("Enter a valid data");
			return;
		}
		
		Node temp = null;
		Node currNode = root;
		
		while(currNode != null) {
			temp = currNode;
			if( Data < currNode.data)
				currNode = currNode.left;
			else
				currNode = currNode.right;
		}
		
		Node newNode = new Node(Data);
		
		newNode.parent = temp;
		if (temp == null) {
			root = newNode;
		}
		
		else if( Data < temp.data ) {
			temp.left = newNode;
		}
		else
			temp.right = newNode;
		
		return;
	}
	
	
	


// Tree-Delete:
	public void nodeDelete(int data) {
		
		// find Node
		Node currNode = treeSearchI(data);
		
		if(currNode == null) {
			System.out.println(data + " is not in the Tree!");
			return;
		}
		
		
		if(currNode.left == null)
			transplant(currNode, currNode.right);
		else if(currNode.right == null)
			transplant(currNode, currNode.left);
		else {
			Node temp = treeMinimum(currNode.right);
			
			if(temp.parent != currNode) {
				transplant(temp, temp.right);
				temp.right = currNode.right;
				temp.right.parent = temp;
			}
			transplant(currNode, temp);
			temp.left = currNode.left;
			temp.left.parent = temp;
		}
		
		System.out.println(data + " DELETED!!");
	}
	
	
	public void transplant(Node u, Node v) {
		if(u.parent == null)
			root = v;
		else if(u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		
		if(v != null)
			v.parent = u.parent;
			
	}
	

	
	
	
	
// Tree-Search
		// Recursive Approach:
	public Node treeSearchR(Node currNode, int data) {	// First Current Node will be 'root'

		if( currNode == null) {
//			System.out.println(data + " does NOT exist!");
			return null;
		}
//		
//		if(data == currNode.data) { 
//			System.out.println(data + " does exist!");
//			return currNode;
//		}
		
		if(data < currNode.data)
			return treeSearchR(currNode.left, data);
		
		else if (data>currNode.data)
			return treeSearchR(currNode.right, data);
		
		return currNode;
	}
	
	
	
	
	// Iterative Approach:
	public Node treeSearchI(int data) {
		
		if(root == null) {
			System.out.println("Tree is Empty!");
			return null;
		}

		Node currNode = root;
		
		while(currNode != null && data != currNode.data) {
			
			if(data > currNode.data)
				currNode = currNode.right;
			else
				currNode = currNode.left;
				
		}
		
//		if(currNode == null)
//			System.out.println("False " + data + " does NOT exist!");
//		else
//			System.out.println("True, " + data + " does exist!");
//		
		return currNode;
		
	}
	
	
	
	
	

	
// Tree-Successor:
	public Node treeSuccessor(Node currNode) {
		if(currNode == null)	// if Node doesn't exist!
			return null;
		
		if(currNode.right != null) {
			return treeMinimum(currNode.right);
		}
		
		// if we're trying to find the successor of NODE from left Tree!
		Node temp = currNode.parent; 
		
		while(temp != null && currNode == temp.right) {
			currNode = temp;
			temp = temp.parent;
		}
		
		return temp;
		
	}
	
// Tree-Predecessor:
	public Node treePredecessor(Node currNode) {
		if(currNode.left != null) {
			return treeMaximum(currNode.right);
		}
		
		// if we're trying to find the successor of NODE from left Tree!
		Node temp = currNode.parent; 
		
		while(temp != null && currNode == temp.left) {
			currNode = temp;
			temp = temp.parent;
		}
		
		return temp;
		
	}
	
	

	
	
	
	
	
// Tree-Minimum
	public Node treeMinimum(Node currNode){
		if(currNode == null) {
			return null;
		}
		
		while(currNode.left != null) {
			currNode = currNode.left;
		}
		
		return currNode;
	}
	
	
	
// Tree-Maximum
	public Node treeMaximum(Node currNode){
		if(currNode == null) {
			return null;
		}

		while(currNode.right != null) {
			currNode = currNode.right;
		}
		
		return currNode;
	}
	

	
	
// Traversal 
	// InOrder (LNR)
	
	public void inOrder() {
		if(root == null) {
			System.out.println("Tree is Empty!");
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public void inOrder(Node currNode) {
		
		if (currNode == null) {
			return;
		}
		
		inOrder(currNode.left);
		System.out.print(currNode.data + " ");
		inOrder(currNode.right);
	}

	
	
	// PreOrder (NLR)
	
	public void preOrder() {
		if(root == null) {
			System.out.println("Tree is Empty!");
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void preOrder(Node currNode) {
		
		if (currNode == null) {
			return;
		}
		
		System.out.print(currNode.data + " ");
		preOrder(currNode.left);
		preOrder(currNode.right);
	}
	
	
	
	// PostOrder (LRN)
	
	public void postOrder() {
		if(root == null) {
			System.out.println("Tree is Empty!");
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postOrder(Node currNode) {
		
		if (currNode == null) {
			return;
		}
		
		postOrder(currNode.left);
		postOrder(currNode.right);
		System.out.print(currNode.data + " ");
	}
	
	
	
// Node Class	
	public static class Node{
		int data;
		Node parent, left, right;
		
		public Node(int data){
			this.data = data;
			this.parent = this.left = this.right = null;
		}
	}
}
