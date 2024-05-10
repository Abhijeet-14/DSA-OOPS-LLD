package _dsa.ByHeart._8_11_21;

import java.util.*;

public class _8Dijkstra_W {
    static List<List<Pair>> vertices = new ArrayList<>();
    static int n, m;
    static boolean visited[];
    static int weight[];
    static int DESTINATION;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = sc.nextInt();

        DESTINATION = 2;

        weight = new int[n];

        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            vertices.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int wt = sc.nextInt();

            vertices.get(x).add(new Pair(y, wt));
            vertices.get(y).add(new Pair(y, wt));
        }

        int source = 0;

        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[source] = 0;

        dijkstra_W(source);

        int destination = 3;

        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + weight[i]);
        }

        sc.close();
    }

    private static void dijkstra_W(int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (a,b) -> a.weight-b.weight);

        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair parent_pair = pq.poll();

            for(Pair child: vertices.get(parent_pair.to)){
                if(weight[child.to]>weight[parent_pair.to] + child.weight)
                {
                    pq.remove(child);
                    weight[child.to] = weight[parent_pair.to] + child.weight;

                    pq.add(new Pair(child.to, weight[child.to]));
                }
            }
        }
    }

    static class Pair{
        int to;
        int weight;

        public  Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
