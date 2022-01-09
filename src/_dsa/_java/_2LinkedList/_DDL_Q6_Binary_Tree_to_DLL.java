package _dsa._java._2LinkedList;

public class _DDL_Q6_Binary_Tree_to_DLL {

	// root --> Root of Binary Tree
	Node root;

	// head --> Pointer to head node of created doubly linked list
	Node head;

	public static void main(String[] args) {

	}

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BToDLL(Node root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			head.left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left);
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

}
