package _dsa._java._1_MATHMATICS;

import java.util.*;

public class C1_Seive_Of_EartoSenthenes {

	public static void main(String[] args) {
		System.out.println(
				"It is used to PRE-PROCESS & store the prime bw a range \n" + "Then access it O(1) time in future \n");
		System.out.println("Enter N for range 1-N: ");

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		boolean isPrime[] = seiveOfEartoSentenes(N + 1);

		for (int i = 0; i < N; i++) {
			System.out.println(i + ": " + isPrime[i]);
		}

		/*
		 * Concept:
		 *
		 * check 2, true Mark all the further multiple of 2 => false
		 * 
		 * check 3, true Mark all the further multiple of 3 => false
		 * 
		 * check 4, false NEXT
		 * 
		 * check 5, true Mark all the further multiple of 5 => false .. .. ..
		 *
		 * In this way only prime numbers will be TRUE in range 1-N;
		 */

		sc.close();
	}

	private static boolean[] seiveOfEartoSentenes(int n) {

		boolean isPrime[] = new boolean[n];

		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			for (int j = 2 * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}	

		return isPrime;
	}

}
