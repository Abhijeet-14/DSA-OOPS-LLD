package _dsa._java;

public class Reverse_A_LinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		System.out.println("\nNormal:");
		printLL(head);
		
		head = reverseLL(head);

		System.out.println("\nrev:");
		printLL(head);

	}
	
	public static Node reverseLL(Node head) {
		if(head == null || head.next == null) return head;
		
		Node temp = head;
		
		Node prev = null;
		Node Next = null;
		
		while (temp != null) { 	
			Next = temp; // 1 2 3 4
			temp = temp.next; // 2 3 4 n
			Next.next = prev; // n 1 2 3
			prev = Next; // 1 2 3 4
		}
		
		return Next;
	}
	
	public static void printLL(Node head) {
		
		if(head == null) {
			return;
		}
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		
		System.out.println();
		return;
	}

	public static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

}
