package _dsa._java._6Sorting;

public class C3_Insertion_Sort {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 8, 20, 2, 18 };

		int n = arr.length;

		// Insertion Sort:
		for (int i = 1; i < n; i++) {
			int j = i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key) {
				// shift the element to right
				arr[j+1] = arr[j];
				j--;
			}
			
			// put at required position
			arr[j+1] = key; 
		}

		System.out.println("SELECTION SORT: O(N^2): \n");

		for (int val : arr)
			System.out.print(val + " ");
	}
}
