package _dsa._java._2LinkedList;

public class Q4_Convert_LL_to_Circular_Linked_List {

	public static void main(String[] args) {

	}

	static Node circular(Node head) {
		Node start = head;

		while (head.next != null)
			head = head.next;

		head.next = start;
		return start;
	}

	static class Node {
		int data;
		Node next;
	};

}
