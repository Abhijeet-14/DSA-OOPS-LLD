package _dsa._1_IMPORTANT_QUES;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Detect_Cycle_Element_In_Graph_And_Node_Distance {
    public static void main(String[] args) {
        //  Node Distances
        //
        //  Consider a connected Graph consisting of nodes and bidirectional edges.
        //  Each edge is 1 unit of distance long, and only one edge connects any two nodes.
        //  There is one cycle in the graph. For each node, determine its shortest
        //  distance from the cycle and return the distances in an integer array.
        //  If a node is in the cycle, its distance is 0
        //
        //  Example :
        //  g_nodes = 6
        //  g_edges = 6
        //  g_from = [1, 2, 1, 3,1, 2]
        //  g_to = [2, 3, 3, 5, 4, 6]
        //
        //  The Merged lists, g_from and g_to are [[1, 2],[2, 3],[1, 3], [3, 5], [1, 4], [2, 6]].
        int gNodes = 6;
        int gFrom[] = {1,2,1,3,1,2};
        int gTo[] = {2,3,5,5,4,6};

        List<List<Integer>> V = new ArrayList<>();
        for(int i = 0; i < gNodes; i++) {
            V.add(new ArrayList<>());
        }

        for(int i = 0; i < gFrom.length; i++) {
            int x = gFrom[i]-1;
            int y = gTo[i]-1;

            V.get(y).add(x);
            V.get(x).add(y);
        }

        boolean visited[] = new boolean[gNodes];

        List<Integer> res = new ArrayList<>();

        HashSet<Integer> s = new HashSet<>();

        for(int i = 0; i < gNodes; i++) {
            if(visited[i] == false)
                if(solve_cycle(V, visited, i, -1, s) == true) {
                    s.add(i+1);
                    break;
                }
        }
        System.out.println(s);
    }

    private static boolean solve_cycle(List<List<Integer>> V, boolean[] visited, int source, int parent, HashSet<Integer> s) {
        visited[source] = true;

        List<Integer> curr = V.get(source);

        for(int child : curr) {
            if(visited[child] == false) {
                if(solve_cycle(V, visited, child, source, s) == true) {
                    s.add(child+1);
                    return true;
                }
            } else if(child != parent) {
                s.add(source+1);
                return true;
            }
//            s.add(child);
        }

        return false;
    }


}
