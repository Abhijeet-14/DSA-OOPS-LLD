package _dsa._15_12_21_practice.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C9_SnakeLadder {
    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        Arrays.fill(moves, -1);

        // Ladder
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] =28 ;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        int result = findThrows(moves, N);
        System.out.println(result);
    }

    private static int findThrows(int[] moves, int n) {
        Queue<Pair> q = new LinkedList<>();
        boolean visited[] = new boolean[n];

        Pair p = new Pair();
        p.v =0;
        p.dist =0;

        q.add(p);

        while(!q.isEmpty()){
            p = q.poll();

            int v = p.v;
            int dist = p.dist;

            // If front vertex is the destination vertex,
            // we are done
            if(v == n-1)
                break;

            for(int i=v+1; i<v+7 && i<n; i++){
                if(visited[i] == false){
                    visited[i] = true;

                    Pair a = new Pair();
                    a.dist=dist+1;  // no of throws

                    // check ladder or snake to jump
                    if(moves[i] != -1)
                        a.v = moves[i];
                    else
                        a.v = i; // just that vertex

                    q.add(a);
                }
            }
        }

        // reached the last vertex.. so no of throws
        return p.dist;
    }
    static class Pair{
        int v;
        int dist;
    }
}
