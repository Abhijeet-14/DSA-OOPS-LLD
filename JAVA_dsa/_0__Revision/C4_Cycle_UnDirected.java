package _dsa._0__Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C4_Cycle_UnDirected {
    static List<List<Integer>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];

        for(int i = 0; i < n; i++)
            V.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            V.get(x).add(y);

            // undirected
            V.get(y).add(x);
        }

        sc.close();

        System.out.println(detectCycle_UD());
    }

    static boolean detectCycle_UD() {
        for(int i = 0; i < V.size(); i++) {
            if(visited[i] == false) {
                if(dfsCycle(i, -1) == true) {
                    System.out.println("source: " + i);
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean dfsCycle(int source, int parent) {
        List<Integer> curr = V.get(source);

        visited[source] = true;

        for(int child : curr) {
            if(!visited[child]) {
                if(dfsCycle(child, source) == true) {
                    return true;
                }
            } else if(parent != child) {
                return true;
            }
        }

        return false;
    }


}
