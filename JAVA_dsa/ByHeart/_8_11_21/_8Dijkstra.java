package _dsa.ByHeart._8_11_21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _8Dijkstra {
    static List<List<Integer>> vertices = new ArrayList<>();
    static int n, m;
    static boolean visited[];
    static int DESTINATION;

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 2 }, { 3, 4 }, { 3, 0 }, { 2, 4 }, };

        n = 5;
        m = edges.length;

        DESTINATION = 4;

        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            vertices.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            vertices.get(x).add(y);
            vertices.get(y).add(x);
        }

        int source = 0;

        List<Integer> distance = dijkstra(source);

        System.out.println("Path: " + distance);

    }

    private static List<Integer> dijkstra(int source) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;
        int count= 0;

        while(!q.isEmpty()){
            int parent_value  = q.poll();

            result.add(parent_value);
            count++;

            for(int child: vertices.get(parent_value)){
                if(!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                }

                if (child == DESTINATION) {
                    result.add(child);
                    System.out.println("Shortest Distance");
                    return result;
                }

            }
        }

        return result;
    }

}
