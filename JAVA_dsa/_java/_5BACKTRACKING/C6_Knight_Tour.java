package _dsa._java._5BACKTRACKING;

import java.util.*;

/*
 * Problem Statement:
 * Given a N*N board with the Knight placed on the first block of an empty board.
 * Moving according to the rules of chess knight must visit each square exactly once.
 * Print the order of each the cell in which they are visited.
 * */
public class C6_Knight_Tour {

	static int N = 8;
	static int board[][] = new int[N][N];

//	static int count = 0;
	public static void main(String[] args) {
		System.out.println("Time: O(8^N^2) \n" + "Space: O(N*N)");
		for (int row[] : board) {
			Arrays.fill(row, -1);
		}

		board[0][0] = 0;

		// count 1, means first move has been done by placing knight at (0, 0).
		boolean isSolve = knightTour(0, 0, 1);

		if (isSolve) {
			printBoard(board);
			System.out.println("Yes, Possible");
		} else {
			printBoard(board);
			System.out.println("Yes, Possible");
		}
	}

	private static boolean isSafe(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && board[r][c] == -1;
	}

	private static boolean knightTour(int row, int col, int count) {
		if (count == N * N)
			return true;

//		int x[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
//		int y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Note: position of x, y effect the run time drastically
		// from top-right -> bottom-right -> bottom-left -> top-left
		int x[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < N; i++) {
			int newRow = row + x[i];
			int newCol = col + y[i];

			if (isSafe(newRow, newCol)) {
				board[newRow][newCol] = count;

				if (knightTour(newRow, newCol, count + 1))
					return true;

				board[newRow][newCol] = -1;
			}
		}

		return false;
	}

	private static void printBoard(int[][] board2) {
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[0].length; j++) {
				System.out.print(board2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
