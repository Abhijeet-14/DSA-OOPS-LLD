package _dsa._java._5BACKTRACKING;

public class C3_Rat_In_A_Maze {

    static int N = 4;
    static int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
    };
    static int sol[][] = new int[N][N];

    public static void main(String[] args) {
        System.out.println("Time Complexity: O(2^(n^2)). \r\n"
                + "Space Complexity: O(n^2)");
        System.out.println("Clarification: We're Travelling N^2 only, but for each move we have 2 possibilities -> 2^(N^2)");

        // rat can move only 1 unit in right and down direction.
        // from (i,j) to
        // Right: (i+1, j)
        // Downward: (i, j+1)

        boolean isSolve = solveMaze();

        System.out.println(isSolve);
    }

    private static boolean solveMaze() {

        if(solveMazeRec(0, 0) == true) {
            printMatrix(sol);
            return true;
        }

        return false;
    }

    public static boolean isSafe(int i, int j) {
        return i < N && j < N && maze[i][j] == 1;
    }

    private static boolean solveMazeRec(int i, int j) {
        // Check if we at destination
        if(i == (N - 1) && j == (N - 1) && maze[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }

        if(isSafe(i, j) == true) {
            sol[i][j] = 1;

            // DownWards
            if(solveMazeRec(i + 1, j) == true)
                return true;
                // Right
            else if(solveMazeRec(i, j + 1) == true)
                return true;

            // Can't go in this direction
            sol[i][j] = 0;
            return false;    // this return is used to return safe cell if doesn't lead to solution
        }

        // No solution
        return false;    // this return is used to return if cell is not SAFE.
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
