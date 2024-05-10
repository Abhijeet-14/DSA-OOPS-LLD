package _dsa._java._5BACKTRACKING;

// BACKTRACKING + DFS
public class C7_count_Island {
    static int mat[][] = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
    };

    static int N = mat.length;
    static int M = mat[0].length;
    static boolean visited[][] = new boolean[N][M];

    public static void main(String[] args) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mat[i][j] == 1 && visited[i][j] == false) {
                    findPath(i, j);
                    ++count;
                }
            }
        }
        System.out.println(count);
    }


    private static void findPath(int i, int j) {
        if(isSafe(i, j)) {
            visited[i][j] = true;
            // right
            findPath(i, j + 1);
            // left
            findPath(i, j - 1);
            // up
            findPath(i - 1, j);
            // down
            findPath(i + 1, j);
        }
    }

    private static boolean isSafe(int i, int j) {
        return i < N && i >= 0 && j < M && j >= 0 && mat[i][j] == 1 && visited[i][j] == false;
    }
}
