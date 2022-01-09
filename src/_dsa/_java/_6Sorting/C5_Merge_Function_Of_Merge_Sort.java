package _dsa._java._6Sorting;

public class C5_Merge_Function_Of_Merge_Sort {

	public static void main(String[] args) {
		int a[] = { 10, 15, 20, 11, 30 };

		int low = 0;
		int mid = 2;
		int high = a.length - 1;

		merge(a, low, mid, high);

		for (int val : a)
			System.out.print(val + " ");

	}

	public static void merge(int a[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++)
			left[i] = a[i];

		for (int i = 0; i < n2; i++)
			right[i] = a[n1 + i];

		int i = 0, j = 0;
		int k = 0;

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
