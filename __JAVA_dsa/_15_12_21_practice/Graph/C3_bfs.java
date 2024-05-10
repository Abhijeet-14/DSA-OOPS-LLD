package _dsa._15_12_21_practice.Graph;

import java.util.*;

public class C3_bfs {
    // Time Complexity: O(V+E)
    // For Each Node we are travelling to its neighbour (Ni)
    // (c+Ni) + (c+Ni) + (c+Ni) + ...
    // (V*C + sum(Ni)_all_vertex)
    // sum(Ni)_all_vertex => Edges = E
    // (V*C + E)
    // O(V+E)

    // Auxiliary Space = O(V) -> visited array or Queue Max Length

    static boolean visited[];
    static List<List<Integer>> V = new ArrayList<>();

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
        }

        for(int i = 0; i < n; i++)
            if(!visited[i])
                bfs(i);
        sc.close();
    }

    private static void bfs(int source) {
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        System.out.println();

        while(!q.isEmpty()) {
            int curr_val = q.poll();

            System.out.print(curr_val + "->");

            List<Integer> curr = V.get(curr_val);

            for(int child : curr) {
                if(!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
}
