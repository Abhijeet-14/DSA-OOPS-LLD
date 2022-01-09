package _dsa._15_12_21_practice.Backtraking;

import java.util.Scanner;

public class C5_N_Queen {
    static int[][] mat;
    static int N;

    public static void main(String[] args) {
        System.out.print("Enter Chess Board Size: ");
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        mat = new int[N][N];

        if(placeQueen(0) == true) {
            printMatrix(mat);
            System.out.println("Yes, Possible to place " + N + " Queens");
        } else
            System.out.println("Not possible");
        System.out.println("\nT.C: O(N^N)");
    }

    private static boolean placeQueen(int col) {
        if(col == N)
            return true;
        for(int i = 0; i < N; i++) {
            if(isSafe(i, col)) {
                mat[i][col] = 1;
                if(placeQueen(col + 1))
                    return true;
                mat[i][col] = 0;
            }
        }

        return false;
    }


    static boolean isSafe(int x, int y) {
        if(x < 0 && y < 0 && x >= N && y >= N && mat[x][y] != 0)
            return false;

        // check horizontally
        for(int i = 0; i < y; i++) {
            if(mat[x][i] != 0)
                return false;
        }

        // check diagonally from x,y to 0,0 && 0,N
        for(int i = 1; i < N; i++) {
            if(x + i < N && y - i >= 0 && mat[x + i][y - i] != 0)
                return false;
            else if(x - i >= 0 && y - i >= 0 && mat[x - i][y - i] != 0)
                return false;
        }

        return true;
    }

    private static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
