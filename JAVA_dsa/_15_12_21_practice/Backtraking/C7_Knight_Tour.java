package _dsa._15_12_21_practice.Backtraking;

import java.util.Arrays;

public class C7_Knight_Tour {
    static int N = 8;
    static int board[][] = new int[N][N];

    public static void main(String[] args) {
        System.out.println("Time: O(8^N^2) \n" + "Space: O(N*N)");
        for(int row[] : board) {
            Arrays.fill(row, -1);
        }

        board[0][0] = 0;

        // count 1, means first move has been done by placing knight at (0, 0).
        boolean isSolve = knightTour(0, 0, 1);

        if(isSolve) {
            printBoard(board);
            System.out.println("Yes, Possible");
        } else {
            printBoard(board);
            System.out.println("Yes, Possible");
        }
    }

    private static boolean isSafe(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N && board[i][j] == -1;
    }

    private static boolean knightTour(int i, int j, int count) {

        if(count == N * N) // total no of moves is equal to 64
            return true;

        int x[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int y[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for(int k = 0; k < N; k++) {
            int newRow = i + x[k];
            int newCol = j + y[k];

            if(isSafe(newRow, newCol)) {
                board[newRow][newCol] = count;
                if(knightTour(newRow, newCol, count + 1))
                    return true;

                board[newRow][newCol] = -1;
            }
        }
        return false;
    }


    private static void printBoard(int[][] board2) {
        for(int i = 0; i < board2.length; i++) {
            for(int j = 0; j < board2[0].length; j++) {
                System.out.print(board2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
