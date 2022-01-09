package _dsa._java._0Arrays;

public class Q1_Array_Rotation {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7};
		int n = 4;
		
		for(int j=0; j<n; j++) {
			int temp = a[0];
			int i;
			for(i=1; i<a.length-j; i++) {
				
				a[i-1] = a[i];
			}
			
			a[i-1] = temp;
		}
		
		
		for(int val: a)
			System.out.print(val + " ");
		
	}

}
