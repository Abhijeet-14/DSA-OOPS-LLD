package _dsa._15_12_21_practice.Graph;

public class C11_min_time_req_to_rottern_all_oranges {
    // Question: https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/

    static int n;
    static int m;
    static boolean visited[][];
    public static void main(String[] args) {
        int v[][] = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };

        n = v.length;
        m = v[0].length;

        visited = new boolean[n][m];

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == false && v[i][j] !=0){
                    dfs(i,j, v, false);
                    count++;
                }
            }
        }

        System.out.println("\nResult: " + count + "\n");

        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs( int x, int  y,int v[][], boolean action){
        if(isSafe(x, y, v)){
            visited[x][y] = true;
            if(v[x][y] == 2)
                action = true;
            else if(v[x][y] == 1 && action){
                v[x][y] = 2;
            }
            dfs(x+1, y, v, action);
            dfs(x-1, y, v, action);
            dfs(x, y+1, v, action);
            dfs(x, y-1, v, action);
        }

    }

    public static boolean isSafe(int x, int y, int v[][]){
        return x>=0 && x<n && y>=0 && y<m && visited[x][y] == false && v[x][y] != 0 ;
    }

}
