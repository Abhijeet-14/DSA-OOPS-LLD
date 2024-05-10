package _dsa._java._2LinkedList;

public class Q6_Nth_Node_from_End_of_LL {

	public static void main(String[] args) {
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(6);

		Node nth = end_simple(head, 4);
		System.out.println("Simple: " + nth.data);
		
		Node nth1 = end_2Pointer(head, 2);
		System.out.println(nth1 != null ? nth1.data : "n > no. of nodes linkedlist");
		
	}

	private static Node end_2Pointer(Node head, int n) {
		// use 2 pointer... say Node nEnd=Head & nHead=Head
		// count = 0
		// we will move nHead till count < n
		// then..
		// if nHead == null... that means nth from last is Head
		// else while(nHead!=null){
		// nHead = nHead.next;
		// nEnd = nEnd.next;
		// }
		// return nEnd;
		//
		// 1 2 3 4 5 6 7; n=3
		// nHead => 1, 2, 3
		// nHead == null ; FALSE, nHead = 4
		// nEnd = nEnd.next -> 2 & nHead = nHead.next -> 5
		// nEnd = nEnd.next -> 3 & nHead = nHead.next -> 6
		// nEnd = nEnd.next -> 4 & nHead = nHead.next -> 7
		// nEnd = nEnd.next -> 5 & nHead = nHead.next -> null
		//
		// So, nTh Node from nEnd = 5

		Node nEnd = head;
		Node nHead = head;

		int count = 0;
		while (count < n) {
			if (nHead == null) {
				return null;
			}

			nHead = nHead.next;
			count++;
		}
		if (nHead == null)
			return head; // Head is the nth node form last

		while (nHead != null) {
			nHead = nHead.next;
			nEnd = nEnd.next;
		}
		
		return nEnd;
	}

	public static Node end_simple(Node head, int n) {
		Node temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		temp = head;

		for (int i = 0; i < len - n; i++)
			temp = temp.next;

		return temp;
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

}
