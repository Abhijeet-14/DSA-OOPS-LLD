package _dsa._java._4Dynamic_Programing;

public class C3_T_SubsetSum {

	static boolean subsetSum( boolean t[][], int arr[], int sum, int n) {
		
		//INITIALIZE
		for(int j =0; j< sum+1; j++)
			t[0][j] = false;
		for(int i =0; i< n+1; i++)
			t[i][0] = true;
		
		// CODE
		for(int i =1; i<n+1; i++) {
			for(int j =1; j<sum+1; j++) {
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][sum];
		
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,7,8,10};
		int sum = 5;
		
		int n = arr.length;
		
		boolean t[][] = new boolean[n+1][sum+1];
		
		System.out.println("o/p: " + subsetSum( t, arr, sum , n));
		
		System.out.println("\nPrint Table:");
		for(int i=0; i<=n; i++) {
			for(int j=0; j<sum+1; j++)
				System.out.print(t[i][j] + " ");
			System.out.println();
		}
	}

}
