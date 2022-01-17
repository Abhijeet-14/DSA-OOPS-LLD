package _dsa._15_12_21_practice.Matrix;

import java.util.HashSet;
import java.util.Set;

public class C1_Set_Mat_0 {
    public static void main(String[] args) {
        int mat[][] = {{0, 1, 0}, {1, 4, 5}, {1, 1, 1}};
        sol_1(mat);
        printMatrix(mat);
        System.out.println("TC-O(n*m) & SC O(n+m)");

        mat = new int[][]{{0, 1, 0}, {1, 4, 5}, {1, 1, 1}};
        sol_2_OPTIMIZE(mat);
        printMatrix(mat);
        System.out.println("TC-O(n*m) & SC O(1)");

    }

    private static void sol_2_OPTIMIZE(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for(int i = 0; i < R; i++) {
            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if(matrix[i][0] == 0) {
                isCol = true;
            }

            for(int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // See if the first row needs to be set to zero as well
        if(matrix[0][0] == 0) {
            for(int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if(isCol) {
            for(int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void sol_1(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    private static void printMatrix(int[][] mat) {
        for(int row[] : mat) {
            for(int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
