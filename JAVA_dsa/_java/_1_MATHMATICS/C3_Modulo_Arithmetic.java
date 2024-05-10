package _dsa._java._1_MATHMATICS;

public class C3_Modulo_Arithmetic {

	public static void main(String[] args) {
		System.out.println("Learn this with example: ");
		System.out.println("Comput a^b%n, n=10^9+7: \n");

		// 3^7
		int a = 3627389;
		int b = 725647;

		// Without modulo - Gives Integer OVERFLOW
		int ans_1 = fastPower_1(a, b);
		System.out.println(ans_1);

		
		// WITH modulo
		// int -> long
		// properties -> 
		//  (a+b)%n => ( a%n + b%n ) %n
		//  (a*b)%n => ( a%n * b%n ) %n
		//  (a-b)%n => ( a%n - b%n ) %n
		long ans_2 = fastPower_2((long) a, (long) b, 1000000007);
		System.out.println(ans_2);
	}

	private static long fastPower_2(long a, long b, int n) {

		long res = 1;

		while (b > 0) {
			if (b % 2 != 0)
				res = (res%n * a%n)%n;

			a = (a%n * a%n)%n;
			b = b / 2;
		}

		return res;
	}

	private static int fastPower_1(int a, int b) {
		int res = 1;

		while (b > 0) {
			if (b % 2 != 0)
				res = res * a;

			a = a * a;
			b = b / 2;
		}

		return res;
	}

}
