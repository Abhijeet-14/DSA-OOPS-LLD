package _dsa._4_2_22_Google.Matrix;

public class C3_print_boundry_Element {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}}; // CORNER CASE
        int mat1[][] = {{1}, {2}, {3}}; // CORNER CASE

        int mat2[][] = {{1,2}, {3,4}};

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

//        1) Move elements of top row.
//        2) Move elements of last column.
//        3) Move elements of bottom row.
//        4) Move elements of first column.
        boundary(mat);
        boundary(mat1);
        boundary(mat2);
        boundary(mat3);
        boundary(mat4);
        boundary(mat5);
    }

    private static void boundary(int[][] mat) {
        System.out.println();
        int N = mat.length, M = mat[0].length;
        int rs = 0, re = N - 1, cs = 0, ce = M - 1;

        if(re == 0) { // only 1 row - Corner Case
            for(int i = cs; i < ce+1; i++)
                System.out.print(mat[re][i] + " ");

        } else if(ce == 0) { // only 1 column - Corner Case
            for(int i = re; i >= rs; i--)
                System.out.print(mat[i][cs] + " ");
        } else {
            // First Row
            for(int i = cs; i < ce + 1; i++) {
                System.out.print(mat[rs][i] + " ");
            }
            rs++;

            // Last Column
            for(int i = rs; i < re + 1; i++) {
                System.out.print(mat[i][ce] + " ");
            }
            ce--;

            // Last Row
            for(int i = ce; i >= cs; i--) {
                System.out.print(mat[re][i] + " ");
            }
            re--;

            // First Column
            for(int i = re; i >= rs; i--) {
                System.out.print(mat[i][cs] + " ");
            }
            cs++;
        }
        System.out.println();
    }

    private static void printMatrix(int[][] mat) {
        System.out.println();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
