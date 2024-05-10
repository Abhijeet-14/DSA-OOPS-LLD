package _dsa._java._4Dynamic_Programing;

public class C4_T_EqualSumPartition {

	static boolean equalSum(boolean t[][], int arr[], int sum, int n) {

		// INITIALIZE
		for (int j = 0; j < sum + 1; j++)
			t[0][j] = false;
		for (int i = 0; i < n + 1; i++)
			t[i][0] = true;

		// CODE
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];

			}
		}

		// uncomment this part to print table
		System.out.println("Print Table \n");
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				System.out.print("|" + t[i][j] + " ");
			}

			System.out.println("\n");
		}

		return t[n][sum];

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2 , 3};
		int sum = 0;

		int n = arr.length;

		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 == 0) {
			boolean t[][] = new boolean[n + 1][(sum / 2) + 1];

			System.out.println("Output: " + equalSum(t, arr, sum / 2, n));
		}

		else
			System.out.println("Output: " + false);

	}
}
