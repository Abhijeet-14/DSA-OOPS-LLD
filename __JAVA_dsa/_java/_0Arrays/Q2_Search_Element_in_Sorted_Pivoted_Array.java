package _dsa._java._0Arrays;

public class Q2_Search_Element_in_Sorted_Pivoted_Array {
	public static void main(String[] args) {
		int a[] = {3,4,5,9,1,2};
		
		int low = 0;
		int high = a.length-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;

			int prev = (a.length + mid-1)%a.length;
			int next = (mid+1)%a.length;

			if(a[mid]>a[prev] && a[mid]>a[next])
			{
				System.out.println(mid);
				break;
			}

			else if( a[mid] >= a[high]) {
				low = mid+1;
			}
			else if( a[mid] <= a[low]) {
				high = mid - 1;
			}
		}
		
	}
}
