package _dsa._java._4Dynamic_Programing;

public class C5_T_CountSubsetOfGivenSum {
	static int subsetSum( int t[][], int arr[], int sum, int n) {
		
		//INITIALIZE
		for(int j =0; j< sum+1; j++)
			t[0][j] = 0;
		for(int i =0; i< n+1; i++)
			t[i][0] = 1;
		
		// CODE
		for(int i =1; i<n+1; i++) {
			for(int j =1; j<sum+1; j++) {
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][sum];
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,3};
		int sum = 6;
		
		int n = arr.length;
		
		int t[][] = new int[n+1][sum+1];
		
		System.out.println(subsetSum( t, arr, sum , n));
		
		System.out.println("\nTable:");
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++){
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
