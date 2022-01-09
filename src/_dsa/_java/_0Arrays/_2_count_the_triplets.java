package _dsa._java._0Arrays;

import java.util.Arrays;

public class _2_count_the_triplets {

	public static void main(String[] args) {

		int arr[] = { 1, 5, 3, 2 };
		int n = 4;

		int naive = countTriplet(arr, n);
		int optimize = countTriplet_optimize(arr, n);

		System.out.println("Count O(n^3) & O(n): " + naive);
		System.out.println("\nCount O(n^2) & O(100000000 = const): " + optimize);

	}

	private static int countTriplet_optimize(int[] arr, int n) {
		boolean isTrue[] = new boolean[100000000];

		for (int val : arr)
			isTrue[val] = true;

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {
				int val = arr[i] + arr[j];

				if (isTrue[val] == true)
					count++;
			}
		}

		return count;
	}

	static int countTriplet(int arr[], int n) {
		int triplet[] = new int[n - 1];

		Arrays.fill(triplet, -1);

		Arrays.sort(arr);

		int count = 0;

		int l = 0;

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {
				triplet[l++] = arr[i] + arr[j];

				if (find(triplet, arr[j]) == true)
					count++;
			}
			Arrays.fill(triplet, -1);
			l = 0;
		}

		return count;
	}

	static boolean find(int arr[], int val) {
		for (int v : arr) {
			if (v != -1 && val == v)
				return true;
		}
		return false;
	}

}
