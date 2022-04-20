package _dsa._4_2_22_Google.Matrix;

public class C2_Rotate_By_1_Element {
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
        System.out.println("Rotation");
//        rotation(mat);
//        rotation(mat1);
//        rotation(mat2);
//        rotation(mat3);
//        rotation(mat4);
        rotation(mat5);
    }

    private static void rotation(int[][] mat) {


        int N = mat.length, M = mat[0].length;
        int rs = 0, re = N - 1, cs = 0, ce = M - 1;
        int res[][] = new int[N][M];

        while(rs <= re && cs <= ce) {
            if(rs == re && rs == cs && cs == ce) {
                res[rs][rs] = mat[rs][rs];
                rs++;
                re--;
                continue;
            }

            // First Row
            for(int i = cs; i < ce; i++) {
                res[rs][i + 1] = mat[rs][i];
            }
            rs++;

            // Last Column
            for(int i = rs; i < re + 1; i++) {
                res[i][ce] = mat[i - 1][ce];
            }
            ce--;

            // Last Row
            for(int i = ce; i >= cs; i--) {
                res[re][i] = mat[re][i + 1];
            }
            re--;

            // First Row
            for(int i = re; i >= rs - 1; i--) {
                res[i][cs] = mat[i + 1][cs];
            }
            cs++;

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
