package _dsa._15_12_21_practice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2_dfs {
    // Time Complexity: O(V+E)
    // For Each Node we are travelling to its neighbour (Ni)
    // (c+Ni) + (c+Ni) + (c+Ni) + ...
    // (V*C + sum(Ni)_all_vertex)
    // sum(Ni)_all_vertex => Edges = E
    // (V*C + E)
    // O(V+E)

    // Auxiliary Space = O(V) -> visited array or Recursion Stack Max Length(V)

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

        for(int i = 0; i < n; i++)
            if(!visited[i]) {
                dfs(0);
            }
    }

    public static void dfs(int source) {
        visited[source] = true;

        List<Integer> curr = V.get(source);

        System.out.print(source + "->");
        for(int child : curr) {
            if(visited[child] == false) {
                visited[child] = true;
                dfs(child);
            }
        }

    }
}
