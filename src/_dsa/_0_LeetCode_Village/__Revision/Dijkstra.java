package _dsa._0_LeetCode_Village.__Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static List<List<Pair>> V = new ArrayList<>();
    static boolean visited[];
    static int weight[];

    public static void main(String[] args) {
        int vertex = 9;

        visited = new boolean[vertex];
        weight = new int[vertex];

        Arrays.fill(weight, Integer.MAX_VALUE);

        int edgesFrom[] = {0,0,1,1,7,7,2,2,2,8,6,3,3,5};
        int edgesTo[] = {1,7,7,2,8,6,8,3,5,6,5,5,4,4};
        int edgeWeight[] = {4,8,11,8,7,1,2,7,4,6,2,14,9,10};


        for(int i=0; i<vertex;i++)
            V.add(new ArrayList<>());

        for(int i=0; i <edgesFrom.length; i++){
            V.get(edgesFrom[i]).add(new Pair(edgesTo[i], edgeWeight[i]));

            // Undirected
            V.get(edgesTo[i]).add(new Pair(edgesFrom[i], edgeWeight[i]));

        }

        dijkstra(0);

        for(int i =0; i<weight.length; i++){
            System.out.println(i+" : "+ weight[i]);
        }
    }

    private static void dijkstra(int source){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

        weight[source] = 0;

        pq.add(new Pair(source, weight[source]));

        while(!pq.isEmpty()){
            Pair currPair = pq.poll();
            List<Pair> currV = V.get(currPair.to);


            for(Pair child: currV){
                if(weight[child.to] > weight[currPair.to] + child.wt){
                    pq.remove(new Pair(child.to, child.wt));

                    weight[child.to] = weight[currPair.to] + child.wt;

                    pq.add(new Pair(child.to, weight[child.to]));
                }
            }
        }
    }
    static class Pair{
        int to;
        int wt;

        public Pair(int to, int wt){
            this.to = to;
            this.wt = wt;
        }


    }
}
