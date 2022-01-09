package _dsa._java._2LinkedList;

public class Q2_Remove_Duplicates_From_Sorted_LinkedList {

	public static Node removeDuplicates(Node root) {
		Node temp = root;

		while (temp != null) {
			if (temp.next != null && temp.next.data == temp.data) {
				Node curr = temp.next;
				temp.next = curr.next;
				curr = null;
			} else {
				temp = temp.next;
			}
		}

		return root;
	}

	class Node {
		int data;
		Node next;
	}
}
