package _dsa._java._4Dynamic_Programing;

import java.util.ArrayList;

public class Gfg_4_Max_Sum_Increaing_SubSequence {

	static int BS_NextImmediate(ArrayList<Integer> t, int element, int start, int end) {
		int mid = (start+ end)/2;
		
		while( start !=mid && end != mid) {
			if(t.get(mid)>= element)
				end = mid;
			else
				start = mid;
			
			mid = (start+end)/2;
		}
		
		if(mid ==0 && t.get(mid)>=element)
			return mid;
		else
			return mid+1;
	}
	
	static int lis_less_k(int arr[]) {
		
		if(arr.length == 0)
			return 0;
		int sum=0;
		
		ArrayList<Integer> t = new ArrayList<>();
		ArrayList<Integer> total = new ArrayList<>();
		
		t.add(arr[0]);
		int len=1;
		
		sum += arr[0];
		total.add(sum);
		
		for(int i =1; i<arr.length ; i++) {
				if(t.get(len-1)<arr[i]) {
					t.add(arr[i]);
					len++;
					sum += arr[i];
				}
				else {
					int index = BS_NextImmediate(t,arr[i], 0, len);
					if(index==len)
						index--;
					sum += arr[i] - t.get(index);
					t.set(index, arr[i]);
				}
				
				total.add(sum);
//				System.out.println(t +" arr" );
//				System.out.println(total +" sum" );
		}
		
		int mx = Integer.MIN_VALUE;
		for(int i=0;i<total.size(); i++) {
			if(total.get(i)>mx)
				mx = total.get(i);
		}
		
		return mx;
	}
	
	public static void main(String[] args) {
//		int arr[] = {468, 335 ,501 ,170 ,725 ,479 ,359 ,963 ,465 ,706 ,146 ,282 ,828 ,962 ,492 ,996 
//				,943 ,828 ,437 ,392 ,605 ,903 ,154 ,293 ,383 ,422 ,717 ,719 ,896 ,448 ,727 ,772 ,539 
//				,870 ,913 ,668 ,300 ,36 ,895 ,704 ,812 ,323};
		
		int arr[] = {1, 101 ,2 ,3 ,100 ,4 ,5};

		System.out.println(lis_less_k(arr));
	}
	
}



