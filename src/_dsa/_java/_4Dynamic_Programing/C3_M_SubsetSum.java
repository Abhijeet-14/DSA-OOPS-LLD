package _dsa._java._4Dynamic_Programing;

public class C3_M_SubsetSum {

	static boolean subsetSum_M( boolean t[][], int arr[], int sum, int n) {
		
		if (sum == 0)
			return t[n][sum] = true;
		if(n==0 && sum != 0)
			return t[n][sum] = false;
		if(arr[n-1] <= sum)
			return t[n][sum] = subsetSum_M(t, arr, sum-arr[n-1], n-1) || subsetSum_M(t, arr, sum, n-1);
		else
			return t[n][sum] = subsetSum_M(t, arr, sum, n-1);
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,7,8,10};
		int sum = 5;
		
		int n = arr.length;
		
		boolean t[][] = new boolean[n+1][sum+1];
		
		System.out.println("o/p: " + subsetSum_M( t, arr, sum , n));
		

		System.out.println("\nPrint Table:");
		for(int i=0; i<=n; i++) {
			for(int j=0; j<sum+1; j++)
				System.out.print(t[i][j] + " ");
			System.out.println();
		}
		
		System.out.println(t[n][sum]);
	}

}
