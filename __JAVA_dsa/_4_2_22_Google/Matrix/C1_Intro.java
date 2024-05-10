package _dsa._4_2_22_Google.Matrix;

public class C1_Intro {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}}; // CORNER CASE
        int mat1[][] = {
                {1},
                {2},
                {3}
        }; // CORNER CASE

        int mat2[][] = {
                {1,2},
                {3,4}
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

        printMatrix(mat);
    }

    private static void printMatrix(int[][] mat) {
        for(int i=0; i<mat.length;i++){
            for(int j=0;j<mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

}
