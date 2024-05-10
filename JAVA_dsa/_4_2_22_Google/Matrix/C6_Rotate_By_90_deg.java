package _dsa._4_2_22_Google.Matrix;

public class C6_Rotate_By_90_deg {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}}; // CORNER CASE
        int mat1[][] = {{1}, {2}, {3}}; // CORNER CASE

        int mat2[][] = {{1, 2}, {3, 4}};

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

        printMatrix(mat3);
        System.out.println("TC-O(n^2), AS-O(n^2)");
        rotate_90_naive(mat3);
        System.out.println("TC-O(n^2), AS-O(1) - IN-PLACE");
        System.out.println("IDEA - Transpose -> reverse");
        rotate_90_optimize(mat3);
    }

    private static void rotate_90_optimize(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Transpose
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < m; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m; j++) {
                int temp = mat[n-i-1][j];
                mat[n-i-1][j] = mat[i][j];
                mat[i][j] = temp;
            }
        }

        printMatrix(mat);
    }

    private static void rotate_90_naive(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res[][] = new int[m][n];

        for(int i = 0; i < n; i++) { // row
            for(int j = 0; j < m; j++) { // col
                // 3-1-1, 0 -> 0 1 => [1][0] = 2
                res[n - j - 1][i] = mat[i][j];
            }
        }

        printMatrix(res);
    }

    private static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
