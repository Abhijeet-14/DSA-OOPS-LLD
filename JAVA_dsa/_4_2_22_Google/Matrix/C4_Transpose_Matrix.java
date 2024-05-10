package _dsa._4_2_22_Google.Matrix;

public class C4_Transpose_Matrix {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}}; // CORNER CASE
        int mat1[][] = {{1}, {2}, {3}}; // CORNER CASE

        int mat2[][] = {{1, 2}, {3, 4}};

        int mat3[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
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

        // IDEA -> swap (i,j) -> (j,i)
        // CORNER CASE -> Transpose only possible for SQUARE MATRIX
        System.out.println("Naive - temp Matrix: TC-O(N^2) AS-O(N^2)");
        transpose_naive(mat3);  // temp matrix needed

        System.out.println("Optimize: In-Place One Traversal TC-O(N^2), AS-O(1)");
        // IDEA -> swap (i,j) -> (j,i) -> BUT don't touch DIAGONAL Element
        transpose_optimize(mat3); // In-place
    }

    private static void transpose_optimize(int[][] mat) {
        int N = mat.length, M = mat[0].length;

        if(N != M) {
            System.out.println("Transpose not possible");
            return;
        }

        printMatrix(mat);
        int res[][] = new int[N][M];

        for(int i = 0; i < mat.length; i++) {
            for(int j = i+1; j < mat[0].length; j++) {
                int temp = mat[i][j];// 0 1
                mat[i][j] = mat[j][i]; // 0 1 1 0
                mat[j][i] = temp; // 1 0 0 1
            }
        }

        printMatrix(mat);
    }

    private static void transpose_naive(int[][] mat) {
        int N = mat.length, M = mat[0].length;

        if(N != M) {
            System.out.println("Transpose not possible");
            return;
        }

        printMatrix(mat);
        int res[][] = new int[N][M];

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                res[i][j] = mat[j][i];
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
