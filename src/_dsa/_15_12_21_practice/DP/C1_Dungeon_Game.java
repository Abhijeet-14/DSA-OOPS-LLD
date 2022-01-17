package _dsa._15_12_21_practice.DP;

public class C1_Dungeon_Game {

    public static void main(String args[]) {
        int points[][] = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int R = 3, C = 3;

        techDose(points, R, C);
        System.out.println("O(N*M) & O(N*M)");
        System.out.println("O(N*M) & O(1)-use point[][] instead of dp[][]");
    }

    private static void techDose(int[][] points, int R, int C) {
        int[][] dp = new int[R][C];

        for(int i = R - 1; i >= 0; i--) {
            for(int j = C - 1; j >= 0; j--) {
                // Bottom-right CELL DESTINATION
                if(i == R - 1 && j == C - 1)
                    dp[i][j] = Math.min(0, points[i][j]);
                    // last ROW
                else if(i == R - 1)
                    dp[i][j] = Math.min(0, points[i][j] + dp[i][j + 1]);
                    // last COL
                else if(j == C - 1)
                    dp[i][j] = Math.min(0, points[i][j] + dp[i + 1][j]);
                    //
                else
                    dp[i][j] = Math.min(0, points[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }

        System.out.println(Math.abs(dp[0][0]) + 1);
    }
}
