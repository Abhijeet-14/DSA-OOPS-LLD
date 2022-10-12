package _dsa._0__Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static List<List<Integer>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        int vertex = 5;

        visited = new boolean[vertex];

        int edgesFrom[] = {0,1,1,1,3,4 };
        int edgesTo[] = {1,2,3,4,2,0};

        for(int i=0; i<vertex;i++)
            V.add(new ArrayList<>());

        for(int i=0; i <edgesFrom.length; i++){
            V.get(edgesFrom[i]).add(edgesTo[i]);

            // Undirected
//            V.get(edgesTo[i]).add(edgesFrom[i]);
        }

        System.out.println(V);
        bfs(0);
    }

    private static void bfs(int source){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        visited[source] =true;
        while(!q.isEmpty()){
            int curr = q.poll();

            List<Integer> currV = V.get(curr);

            System.out.print(curr + " -> ");
            for(int child: currV){
                if(visited[child] == false){
                    q.add(child);
                    visited[child] =true;
                }
            }
        }
    }
}
