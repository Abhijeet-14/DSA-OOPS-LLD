package _dsa._0_restart.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class C9_Rotten_Oranges {
    public static void main(String[] args) {
        // 2 - rotten
        // 1 - fresh
        // 0 - empty space
        // Problem: rotten oranges - affect(make rotten) its adjacent oranges.

        // Find the time to rotten all oranges in a basket. return -1 if not able to rotter all oranges.

        // Logic:
        // use a queue,
        // travel thro whole basket
        // and put element as (time, x-y) whose value is 2.
        // now pop element and make adjacent 2 if possible.
        // now put to Queue with time+1.

        int mat[][] = {
                {2,1,0,2,1},
                {0,0,1,2,1},
                {1,0,0,2,1},
        };

        int ans = solve(mat);
        System.out.println("Ans: " + ans);
        System.out.println("Time: O(N*M), AS - O(N*M)");
    }

    private static int solve(int mat[][]){
        // Queue to store time, x, y
        Queue<Pair> q = new LinkedList<>();

        // Travel basket & store value = 2
        for(int i=0;i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int time = -1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            time = curr.time;
            if(isSafe(mat, curr.x+1, curr.y)) {
                q.add(new Pair(curr.x + 1, curr.y, curr.time + 1));
                mat[curr.x+1][curr.y] = 2;
            }
            if(isSafe(mat, curr.x-1, curr.y)) {
                q.add(new Pair(curr.x - 1, curr.y, curr.time + 1));
                mat[curr.x - 1][curr.y] = 2;
            }
            if(isSafe(mat, curr.x, curr.y+1)) {
                q.add(new Pair(curr.x, curr.y + 1, curr.time + 1));
                mat[curr.x][curr.y+1] = 2;
            }
            if(isSafe(mat, curr.x, curr.y-1)) {
                q.add(new Pair(curr.x, curr.y - 1, curr.time + 1));
                mat[curr.x][curr.y-1] = 2;
            }
        }

        // check all are rotter
        for(int i=0;i<mat.length; i++){
            for(int j =0; j<mat[0].length; j++)
                if(mat[i][j] == 1)
                    return -1;
        }
        return time;
    }

    private static boolean isSafe(int mat[][], int x, int y){
        int N = mat.length;
        int M = mat[0].length;

        return x>=0 && x<N && y >= 0 && y < M && mat[x][y] == 1;
    }

    static class Pair {
        int x, y, time;

        public Pair(int x, int y, int time) {
            this.x =x;
            this.y =y;
            this.time =time;
        }
    }

}
