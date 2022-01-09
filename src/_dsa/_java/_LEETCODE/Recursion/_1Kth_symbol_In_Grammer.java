package _dsa._java._LEETCODE.Recursion;

import java.util.Scanner;

// Question: https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/

// Response: QUIT!

public class _1Kth_symbol_In_Grammer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no. of rows:");
		int N = sc.nextInt();
		System.out.println("Enter index:");
		int K = sc.nextInt();

		System.out.println(kthGrammar(N, K));

		sc.close();
	}

	public static int kthGrammar(int N, int K) {
		if (N == 1)
			return 0;
		if (K % 2 == 0)
			return (kthGrammar(N - 1, K / 2) == 0 ? 1 : 0);
		else
			return (kthGrammar(N - 1, (K + 1) / 2) == 0 ? 0 : 1);
		// kthGrammar(N-1,(K+1)/2) == 1 ? 1 : 0;

	}

}
