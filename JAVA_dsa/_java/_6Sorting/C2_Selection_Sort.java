package _dsa._java._6Sorting;

public class C2_Selection_Sort {

	public static void main(String[] args) {
		int arr[] = {10, 5, 8, 20, 2, 18};
		
		int n = arr.length;
		
		// Selection Sort:
		for(int i =0; i<n-1; i++) {
			int min_index = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[ min_index]) {
					min_index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[min_index]; 
			arr[min_index] = temp;
		}
		
		System.out.println("SELECTION SORT: O(N^2): \n");
		
		for(int val: arr)
			System.out.print(val + " ");
	}
}
