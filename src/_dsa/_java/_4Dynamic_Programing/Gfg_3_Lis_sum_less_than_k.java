package _dsa._java._4Dynamic_Programing;

import java.util.ArrayList;

public class Gfg_3_Lis_sum_less_than_k {
	static int BS_NextImmediate(ArrayList<Integer> t, int element, int start, int end) {
		
		if(t.size() ==1)
			return 0 ;
		int mid = (start+ end)/2;
		
		while( start !=mid && end != mid) {
			if(t.get(mid)>= element)
				end = mid;
			else
				start = mid;
			
			mid = (start + end)/2;
		}
		
		if(mid ==0 && t.get(mid)>=element)
			return mid;
		else
			return mid+1;
	}
	
	static int lis_less_k(int arr[],int k) {
		
		if(arr.length == 0)
			return 0;
		int sum=0;
		
		ArrayList<Integer> t = new ArrayList<>();
		
		int len=0;
		
		if(arr[0]>k)
			sum = 0;
		else {
			t.add(arr[0]);
			sum += arr[0];
			len = 1;
		}
//		System.out.println(sum);
		
		for(int i =1; i<arr.length ; i++) {
			if(len==0 ) {
				if(arr[i]<k) {
					t.add(arr[i]);
					sum += arr[i];
					len++;
				}
			}
			else if(t.get(len-1)<arr[i]) {
						sum += arr[i];
						if(sum<k) {
							t.add(arr[i]);
							len++;
						}
						else
							sum -=arr[i];
				}
				else {
//					System.out.print(t+" for-" + arr[i] + " ");
					int index = BS_NextImmediate(t,arr[i], 0, len);
					if(index==len)
						index--;
					sum += arr[i] - t.get(index);
					if(sum<k)
						{
						t.set(index, arr[i]);
//						System.out.println(t);
						}
					else
						sum -= arr[i] - t.get(index);

				}
//			System.out.println(sum);
			}
		
//		System.out.println(t);
		return t.size();
	}
	
	public static void main(String[] args) {
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 19};
//		int arr[] = {5, 8, 3, 7, 9, 1} ;
//		int arr[] = {1, 101 ,2 ,3 ,100 ,4 ,5};
		
		int k = 40;
		
		System.out.println(lis_less_k(arr,k));
	}

}
