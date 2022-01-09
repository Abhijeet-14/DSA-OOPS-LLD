package _dsa._java._1_MATHMATICS;

public class C4_Trailing_ZEROS_in_Fractorial {

	public static void main(String[] args) {
		int  n = 60;
		
		int res = 0;
		
		for(int i=5; i<n; i = i*5) {
			res = res + n/i;
		}
		
		System.out.println("Trailing Zeros: " + res);
	}

}
