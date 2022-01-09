package _dsa._java._6Sorting;

public class C6_Merge_Sort_Algorithm {
	
	public static void main(String[] args) {
		int arr[] = {10, 5, 30, 15, 7};
		
		int l = 0; 
		int r = arr.length -1;
		
		mergeSort(arr, l, r);
		
		System.out.println("O(nlogn)");
		
		for(int val: arr) 
			System.out.print(val + " ");
		
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if(r>l)	// at-least 2 elements
		{
			int m = l + (r-l)/2;
			
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}

	public static void merge(int a[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++)
			left[i] = a[l+i];

		for (int i = 0; i < n2; i++)
			right[i] = a[n1 + l + i];	// e.g. l=3 & n1=2.. J=> (2+3+0)

		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			a[k] = left[i];
			i++;
			k++;
		}

		while (j < n2) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
}
