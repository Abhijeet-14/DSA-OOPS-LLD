package _dsa._java._6Sorting;

import java.util.Arrays;

public class C4_Merge_Two_Sorted_Array {

	public static void main(String[] args) {
		int a[] = {10, 15, 20};
		int b[] = {5, 6, 6, 15};
		
		int n = a.length;
		int m = b.length;
		// Naive
		int c[] = new int[n+ m];
		for(int i=0; i<n;i++)
			c[i] = a[i];
		
		for(int i=0; i<m;i++)
			c[n + i] = b[i];
		
		Arrays.sort(c);
		
		System.out.println("Naive O((N+M)*log(N+M)):");
		for(int val: c)
			System.out.print(val + " ");
		
		System.out.println("\n\nEfficient: O(N+M)");
		int i=0, j=0;
		
		while(i<n && j<m) {
			if(a[i] <= b[j]) {
				System.out.print(a[i] + " ");
				i++;
			}
			else {
				System.out.print(b[j] + " ");
				j++;
			}
		}
		
		while(i<n) {
			System.out.print(a[i] + " ");
			i++;
		}
		
		while(j<n) {
			System.out.print(b[j] + " ");
			j++;
		}
		
		
	}

}
