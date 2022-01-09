package _dsa._java._0Arrays;

public class Q2_Search_Element_in_Sorted_Pivoted_Array {
	public static void main(String[] args) {
		int a[] = {3,4,5,9,1,2};
		
		int low = 0;
		int high = a.length-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			
			if(mid<high && a[mid]>a[mid+1]) {
				System.out.println(mid); break; 
			}
			else if( mid>low && a[mid]>a[mid-1])
				System.out.println(mid-1);
			else if( a[mid] >= a[high]) {
				low = mid+1;
			}
			else if( a[mid] <= a[low]) {
				high = mid - 1;
			}
		}
		
	}
}
