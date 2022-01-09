package _dsa._java._6Sorting;

public class C1_Bubble_Sort {

	public static void main(String[] args) {
		int arr[] = {2, 10, 8, 7};
		
		int n = arr.length;
		
		// Bubble Sort:
		for(int i =0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1]; 
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println("BUBBLE SORT: O(N^2): \n");
		
		for(int val: arr)
			System.out.print(val + " ");
	}

}
