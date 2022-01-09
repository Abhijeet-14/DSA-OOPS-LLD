package _dsa._java._5BACKTRACKING;

import java.util.*;

public class C4_N_Queen {

	static int N;

	public static void main(String[] args) {
		System.out.println("");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter chess board size");
		N = sc.nextInt();

		int board[][] = new int[N][N];

		for (int[] row : board)
			Arrays.fill(row, 0);

		boolean isSolve = solveBoard(board, 0);

		if (isSolve == true) {
			System.out.println("YES, POSSIBLE");
			printMatrix(board);
		} else
			System.out.println("NO, Not Possible");

		sc.close();
	}

	private static boolean isSafe(int[][] board, int r, int c) {

		// Row Check
		for (int i = 0; i < c; i++) {
			if (board[r][i] == 1)
				return false;
		}

		// Upward diagonal check
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		// Downward diagonal check
		for (int i = r, j = c; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}

		return true;
	}

	private static boolean solveBoard(int[][] board, int col) {
		if (col >= N)
			return true;

		// checking in row
		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col) == true) {
				// Place this queen in board[i][col]
				board[i][col] = 1;

				// solve for further queens position
				if (solveBoard(board, col + 1) == true)
					return true;

				// if placement doesn't lead to solution, then remove the queen.
				board[i][col] = 0;

			}
		}

		// Not safe.
		return false;
	}

	private static void printMatrix(int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
