package _dsa._15_12_21_practice.Backtraking;

public class C6_Suduko {
    static int mat[][] = {
            {1, 0, 3, 0},
            {0, 0, 2, 1},
            {0, 1, 0, 2},
            {2, 4, 0, 0},
    };
    static int N;
    static int subGrid;

    public static void main(String[] args) {
        System.out.println("Naive: Time:\n\t  O(9^(n*n))");
        System.out.println("Backtracking:\n\t Time: O(9^(n*n)) .. it is the upper bound, but it takes time very less than naive \n\t "
                + "Space: O(n*n)");
        N = 9;

        mat = new int[N][N];


        subGrid = (int) Math.sqrt(N);

        if(solveSuduko()) {
            System.out.println("Yes Possible");
            printMatrix(mat);
        } else {
            printMatrix(mat);
            System.out.println("Not Possible");
        }
    }

    private static boolean solveSuduko() {
        // find First empty cell
        int i = 0;
        int j = 0;
        boolean flag = false;
        for(i = 0; i < N; i++) {
            for(j = 0; j < N; j++) {
                if(mat[i][j] == 0) {
                    flag = true;
                    break; // got the empty cell
                }
            }
            if(flag)
                break;
        }

        if(i == N && j == N)
            return true;

        for(int k = 1; k <= N; k++) {
            if(isSafe(i, j, k)) {
                mat[i][j] = k;
                if(solveSuduko())
                    return true;
                mat[i][j] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int x, int y, int val) {
        // range
        if(x >= N || y >= N || x < 0 || y < 0 || mat[x][y] != 0)
            return false;

        // horizontally & vertically
        for(int i = 0; i < N; i++) {
            if(mat[i][y] == val || mat[x][i] == val)
                return false;
        }

        // check subgrid
        int rowStart = x - (x % subGrid);
        int colStart = y - (y % subGrid);

        for(int i = 0; i < subGrid; i++) {
            for(int j = 0; j < subGrid; j++) {
                if(mat[i + rowStart][j + colStart] == val)
                    return false;
            }
        }
        return true;
    }


    private static void printMatrix(int mat[][]) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
