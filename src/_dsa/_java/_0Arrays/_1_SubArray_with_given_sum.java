package _dsa._java._0Arrays;

// Question:  https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

public class _1_SubArray_with_given_sum {

	public static void main(String[] args) {

		int Sum = 12;
		int arr[] = { 1, 2, 3, 7, 5 };

		System.out.println("Naive: O(n^2)");
		naive(Sum, arr);

		System.out.println("\nOptimize: O(n)");
		optimize(Sum, arr);

	}

	private static void optimize(int sum, int[] arr) {
		int newArr[] = new int[arr.length];

		int i = 0, s = 0, l = 0;

		for (int val : arr) {
			s += val;
			newArr[i++] = s;
		}

		s = newArr[0];

		for (i = 1; i <= newArr.length;) {
			System.out.print(s + " " + newArr[l] + "\n");
			if (s == sum) {
				s -= newArr[l];
				l++;
			} else if (s > sum) {
				s -= newArr[l++];
			} else {
				if (i < newArr.length)
					s = newArr[i];

				i++;
			}
		}
	}

	private static void naive(int sum, int[] arr) {
		int s = 0;

		for (int i = 0; i < arr.length; i++) {

			s = arr[i];

			for (int j = i + 1; j < arr.length; j++) {

				s += arr[j];

				if (s > sum) {
					break;
				} else if (s == sum) {
					System.out.println("Index: " + i);
					break;
				}
			}
		}
	}

}
