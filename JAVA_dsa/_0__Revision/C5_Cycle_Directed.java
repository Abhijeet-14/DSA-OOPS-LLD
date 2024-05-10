package _dsa._0__Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C5_Cycle_Directed {
    static List<List<Integer>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;

        visited = new boolean[n];

        for(int i = 0; i < n; i++)
            V.add(new ArrayList<>());


        int eFrom[] = {0,1,3,0};
        int eTo[] = {1,3,0,2};

        int m = eTo.length;

        for(int i = 0; i < m; i++) {
            int x = eFrom[i];
            int y = eTo[i];

            V.get(x).add(y);

            // undirected
//            V.get(y).add(x);
        }

        sc.close();

        System.out.println(detectCycleD());
        printGraph(V, n);
    }

    static boolean recSt[];

    private static boolean detectCycleD() {
        recSt = new boolean[V.size()];

        for(int i = 0; i < V.size(); i++) {

            if(visited[i] == false) {
                if (dfsRec(i, -1) == true){
                    System.out.println("Cycle at: " + i);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsRec(int source, int parent) {
        List<Integer> curr = V.get(source);

        visited[source] = true;
        recSt[source] = true;

        for(int child : curr) {
            if(visited[child] == false) {
                if(dfsRec(child, source) == true)
                    return true;
            } else if(recSt[child] == true)
                return true;
        }

        recSt[source] = false;

        return false;
    }

    public static void printGraph(List<List<Integer>> adj, int V) {
        for(int i = 0; i < V; i++) {
            System.out.print(i + "->");
            for(int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
