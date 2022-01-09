package _dsa._java._LEETCODE.Dynamic_Programing;

/*
 * Question: https://leetcode.com/problems/divisor-game/
 * 
 * Response: SOLVED 100%
 * 
 */

public class E1_Divisor_Game {

	public static void main(String[] args) {
		// 0<N<1000
		int N = 4;
		boolean ans = myApproach(N);
		System.out.println("MyApproach: 100%, \n" + ans);

		boolean ans1 = optimize(N);
		System.out.println("\nOne-line Solution: 100%, \n" + ans1);
	}

	private static boolean optimize(int N) {
		return N % 2 == 0;
		// if 0, the last move was of BOB, if 1 last move of ALICE
	}

	public static boolean myApproach(int N) {
		// turn = true => alice's turn
		// turn = false => bob's turn
		boolean turn = true;
		return solve(N, turn);
	}

	public static boolean solve(int N, boolean turn) {
		// No more valid move
		if (N == 1)
			return !turn;
		// if turn = false.. means current turn is for Bob's.. so Alice wons.. else
		// vice-versa.

		// turn=false, current is Bob's turn.. so call next for Alice turn
		if (turn == false)
			return solve(N - 1, true);

		return solve(N - 1, false);
	}

}
