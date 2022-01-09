package _dsa._java._1_MATHMATICS;

public class C2_GCD {

	public static void main(String[] args) {
		int ans = gcd(16, 72);
		
		System.out.println("GCD: " + ans);
		
		// LCM = a*b/GCD;
		System.out.println("LCM: " + (16*72)/ans);
	}
	
	private static int gcd(int a, int b) {
		// a > b
		
		if( b == 0 )
			return a;
		
		return gcd( b, a%b );
	}

}
