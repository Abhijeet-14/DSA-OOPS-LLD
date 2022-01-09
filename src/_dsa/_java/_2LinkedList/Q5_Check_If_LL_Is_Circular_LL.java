package _dsa._java._2LinkedList;


public class Q5_Check_If_LL_Is_Circular_LL {

	public static void main(String[] args) {

	}

	boolean isCircular(Node head) {
		if (head == null)
			return true;

		Node node = head.next;

		while (node != null && node != head)
			node = node.next;

		return (node == head);
	}

	static class Node {
		int data;
		Node next;
	};

}
