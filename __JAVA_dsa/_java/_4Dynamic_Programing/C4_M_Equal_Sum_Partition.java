package _dsa._java._4Dynamic_Programing;

public class C4_M_Equal_Sum_Partition {
	static boolean equalSum(boolean t[][], int arr[], int sum, int n) {

		// INITIALIZE
		if (sum == 0)
			return true;

		if (n == 0)
			return false;

		if (t[n][sum] == true)
			return t[n][sum];

		if (arr[n - 1] <= sum)
			return t[n - 1][sum] = equalSum(t, arr, sum - arr[n - 1], n - 1) || equalSum(t, arr, sum, n - 1);

		return t[n - 1][sum] = equalSum(t, arr, sum, n - 1);
	}


	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2 };
		int sum = 0;

		int n = arr.length;

		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 == 0) {
			boolean t[][] = new boolean[n + 1][(sum / 2) + 1];
			printTable(t);
			System.out.println("Output: " + equalSum(t, arr, sum / 2, n));
		}

		else
			System.out.println("Output: " + false);

	}
	
	
	public static void printTable(boolean[][] t) {
		System.out.println("Print Table \n");
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				System.out.print("|" + t[i][j] + " ");
			}

			System.out.println("\n");
		}
	}


}
