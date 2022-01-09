package _dsa._java._2LinkedList;

public class Q3_Reverse_LL {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
//		System.out.println("Iterative:");
//		Node rev = reverseList(head);
//		
//		while(rev !=null) {
//			System.out.print(rev.data + "->");
//			rev = rev.next;
//		}
		
		System.out.println("\nRecursive:");
		
		Node prev = null;
		
		Node rev1 = reverseList_rec(head, prev);
		
		while(rev1 !=null) {
			System.out.print(rev1.data + "->");
			rev1 = rev1.next;
		}
	}

	private static Node reverseList_rec(Node head, Node prev) {
		if(head == null)
			return prev;
		
		Node temp = head.next;
		head.next = prev;
		prev = head;
		
		return reverseList_rec(temp, prev);
	}

	public static Node reverseList(Node head) {
		// code here
		Node temp = head;

		Node dummy = null;

		while (temp != null) {
			Node curr = temp.next;
			temp.next = dummy;
			dummy = temp;
			temp = curr;
		}

		head = dummy;

		return head;
	}
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
