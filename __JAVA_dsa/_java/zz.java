package _dsa._java;

import java.util.Scanner;

public class zz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		sc.nextLine();

		String b = sc.nextLine();

		while (a < 4) {
			b += sc.next();
			a++;
		}

		System.out.println(a);
		System.out.println(b);
		System.out.println(b.charAt(3));

		sc.close();
	}

}
