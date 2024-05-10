package _dsa._4_2_22_Google.Matrix;

public class C8_Print_Spiral_Pattern {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}}; // CORNER CASE
        int mat1[][] = {
                {1},
                {2},
                {3}
        }; // CORNER CASE

        int mat2[][] = {
                {1, 2},
                {3, 4}
        };

        int mat3[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int mat4[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int mat5[][] = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
        };

        printMatrix(mat5);

        System.out.println("TC-O(N*M) - AS-O(N*M)");
//        spiral(mat);
//        spiral(mat1);
//        spiral(mat2);
//        spiral(mat3);
//        spiral(mat4);
        spiral(mat5);
    }

    private static void spiral(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = m - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            // F-Row
            for(int i = colStart; i <= colEnd; i++) {
                System.out.print(mat[rowStart][i] + " ");
            }
            rowStart++;
            System.out.print(" | ");

            for(int i = rowStart; i <= rowEnd; i++) {
                System.out.print(mat[i][colEnd] + " ");
            }
            colEnd--;
            System.out.print(" | ");

            if(rowStart <= rowEnd)
                for(int i = colEnd; i >= colStart; i--) {
                    System.out.print(mat[rowEnd][i] + " ");
                }
            rowEnd--;
            System.out.print(" | ");

            if(colStart <= colEnd)
                for(int i = rowEnd; i >= rowStart; i--) {
                    System.out.print(mat[i][colStart] + " ");
                }
            colStart++;
            System.out.print(" | ");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

}
