package _dsa._java;

import java.util.*;

public class Q1_Reverse_K_Element_In_Queue {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < 10; i++)
			q.add(i);

		int count = 5;
		int len = q.size();
		int stop = len - count;

		while (!q.isEmpty()) {
			// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			if (count != 0) {
				s.push(q.poll());
				count--;
			} else
				break;
		}

		while (!s.isEmpty())
			q.add(s.pop());

		while (stop != len) {
			q.add(q.poll());
			stop++;
		}
		
		System.out.println(q);
	}

}
