package _dsa._java._4Dynamic_Programing;

import java.util.*;

public class C6_Minimum_Subset_Sum_Diff {

	static boolean t[][];

	public static void main(String[] args) {
		int arr[] = { 1, 6, 11, 5 };
		int n = arr.length;

		int Range = 0;

		for (int val : arr)
			Range += val;

		t = new boolean[n + 1][Range + 1];

		// S1+S2 = Sum Of Array (RANGE)
		// S1-S2 = Minimum difference

		// 2*S1 = Range + Minimum Difference
		// Minimum Difference = Range - 2*S1

		// in bw 0-Range...
		// remove all the number which does not have any subset in arr[]

		// HOW to remove?

		// in n-row of t[][], we have true for only subsets... so.. if true => have
		// subset
		
		System.out.println("This needs to be solved by TABULATION: WHY? \n"
				+ "Bcoz in Memoization we direct jump on Range Subse.. \n" + "but we need every number's subset bw 0-Range");
		
		tabu(arr, n, Range);

		List<Integer> validNum = new ArrayList<>();

		for (int i = 1; i < Range + 1; i++) {
			// removing NUMBER with No Subset in arr[]
			if (t[n][i] == true)
				validNum.add(i);
		}

		int mn = Integer.MAX_VALUE;

		for (int val : validNum)
			if (val<=Range/2 && mn > Range - (2 * val))
				mn = Range - (2 * val);

//		printTable(t);
		System.out.println(validNum);
		System.out.println(mn);
	}

	private static void tabu(int[] arr, int n, int range) {
		for (int i = 0; i < range + 1; i++)
			t[0][i] = false;

		for (int i = 0; i < n + 1; i++)
			t[i][0] = true;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < range + 1; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
	}

	public static void printTable(boolean[][] tab) {
		System.out.println("Print Table:");
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++)
				System.out.print(tab[i][j] + " ");
			System.out.println();
		}

		System.out.println(tab[tab.length - 1][tab[0].length - 1]);
	}
}
