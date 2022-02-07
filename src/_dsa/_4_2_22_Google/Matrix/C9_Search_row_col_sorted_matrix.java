package _dsa._4_2_22_Google.Matrix;

import java.net.Socket;

public class C9_Search_row_col_sorted_matrix {
    public static void main(String[] args) {
        int mat[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {17, 27, 37, 47},
                {19, 29, 39, 49}
        };

        printMatrix(mat);

        System.out.println("TC-O(N*M) - travel row-wise and check element");
        search_naive(mat, 47);

        System.out.println("\nTC-O(N + M) - start from top-right");
        // IDEA - start from top-right
        // if x==target, print,
        // if x smaller than target, go down.
        // if x greater than target, go left.
        search_optimize(mat, 29);

        // Why top-right?? if T>X row++ & T<X => col--
        // bcoz at top-left => if T<X.. we say not present => but if T>X => we can't say whether to go row++ or col++
        // bcoz at bottom-right => if T>X.. we say not present => but if T<X => we can't say whether to go row-- or col--

        // BUT
        // bcoz at bottom-left => if T>X col++ & T<X => row--  =>=> POSSIBLE!!
    }

    private static void search_optimize(int[][] mat, int X) {
        int rowStart = 0, colStart = mat[0].length - 1;

        while(rowStart < mat.length && colStart >= 0) {
            if(mat[rowStart][colStart] == X) {
                System.out.println(mat[rowStart][colStart] + " at: (" + rowStart + "," + colStart + ")");
                break;
            } else if(mat[rowStart][colStart] < X)
                rowStart++;
            else
                colStart--;
        }
    }

    private static void search_naive(int[][] mat, int target) {
        boolean flag = false;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == target) {
                    System.out.println(mat[i][j] + " at: (" + i + "," + j + ")");
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                break;
        }
    }

    private static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

}
