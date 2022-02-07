package _dsa._15_12_21_practice.Backtraking;

public class C3_RatMaze {
    static int N = 4;
    static int M = 4;
    static int maze[][];
    static int solution[][];

    public static void main(String[] args) {
        System.out.println("Time Complexity: O(2^(n^2)). \r\n"
                + "Space Complexity: O(n^2)");
        System.out.println("Clarification: We're Travelling N^2 only, but for each move we have 2 possibilities -> 2^(N^2)");

        maze = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 0},
        };
        // 0 - Block & 1 - Go
        // Moves allowed(i,j) - right(i,j+1) & down(i+1,j)
        // need to reach till (N,N)

        solution = new int[N][M];

        boolean result = findPath(0, 0);
        System.out.println("Result: " + result);
    }

    private static boolean findPath(int i, int j) {
        if(solveMaze(i, j) == true) {
            printMatrix(solution);
            return true;
        }

        return false;
    }

    private static boolean solveMaze(int i, int j) {
        if(i == N - 1 && j == M - 1 && maze[i][j] == 1) // DESTINATION (N,M)
        {
            solution[i][j] = 1;
            return true;
        }
        if(isSafe(i, j)) {
            solution[i][j] = 1;

            // DOWN
            if(solveMaze(i + 1, j) == true)
                return true;
            // right
            else if(solveMaze(i, j + 1) == true)
                return true;

            solution[i][j] = 0;
            return false;
        }

        return false;
    }

    private static boolean isSafe(int i, int j) {
        // means we can move to this (i,j)
        return i < N && j < M && maze[i][j] == 1;
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
