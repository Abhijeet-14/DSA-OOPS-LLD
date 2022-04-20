package _dsa._0_LeetCode_Village.__Revision;

import java.util.ArrayList;
import java.util.List;

public class DFS {
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
        dfs(0);
    }

    private static void dfs(int source){
        visited[source] = true;

        List<Integer> currV = V.get(source);

        System.out.print(source + " -> ");
        for(int child: currV){
            if(visited[child]==false){
                dfs(child);
            }
        }
    }
}
