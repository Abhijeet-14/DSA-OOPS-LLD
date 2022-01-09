package _dsa._15_12_21_practice.Graph;

import java.util.*;

public class C7_Dijkstra_Wt {

    // Time Complexity - O((V+E)LogV)
    static List<List<Pair>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 9;
        int m = 14;

        int edges[][] = {
                {0, 1, 4},
                {0, 7, 8},
                {1, 7, 11},
                {1, 2, 8},
                {7, 8, 7},
                {7, 6, 1},
                {2, 8, 2},
                {2, 3, 7},
                {2, 5, 4},
                {8, 6, 6},
                {6, 5, 2},
                {3, 5, 14},
                {3, 4, 9},
                {5, 4, 10}
        };

        visited = new boolean[n];

        for(int i = 0; i < n; i++) // O(V)
            V.add(new ArrayList<>());

        for(int i = 0; i < m; i++) { // O(E)
            int x = edges[i][0];
            int y = edges[i][1];
            int wt = edges[i][2];

            V.get(x).add(new Pair(y, wt));

            // undirected
            V.get(y).add(new Pair(x, wt));
        }

        sc.close();

        int weight[] = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE); // O(V)

        dijkstra(0, weight);

        System.out.println("V - Distance");

        for(int i = 0; i < V.size(); i++) // O(V)
            System.out.println(i + " - " + weight[i]);
    }

    private static void dijkstra(int source, int[] weight) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(weight.length, (a, b) -> a.wt - b.wt);

        pq.add(new Pair(source, 0)); // C
        weight[source] = 0; // C

        while(!pq.isEmpty()) { // logE + E*LogE => O(E*logE)

            Pair curr_pair = pq.poll(); // LogE

            List<Pair> curr = V.get(curr_pair.y); // C

            for(Pair child : curr) { // E: each edge 1 time only
                // x-travel_wt + y.edge_wt < y-travel_wt
                if(weight[curr_pair.y] + child.wt < weight[child.y]) { // c
                    pq.remove(new Pair(child.y, weight[child.y])); // logE
                    weight[child.y] = weight[curr_pair.y] + child.wt; // c
                    pq.add(new Pair(child.y, weight[child.y])); // logE
                }
            }
        }
    }

    static class Pair {
        int y;
        int wt;

        public Pair(int y, int wt) {
            this.wt = wt;
            this.y = y;
        }
    }
}
