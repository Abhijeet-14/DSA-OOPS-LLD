package _dsa._0_JOB_Change.T2_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1_Critical_Connections_In_A_Network_Unsolved {
    public static void main(String[] args) {
        // 5
        // [[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
    }
    static List<List<Integer>> V  = new ArrayList<>();
    // static Set<Integer> set = new HashSet<>();
    static boolean visited[];
    static Map<Integer, Integer> map = new HashMap<>();

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        if(n<=2)
            return connections;

        visited = new boolean[n];

        for(int i=0;i<n;i++){
            V.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
            int x = connections.get(i).get(0);
            int y = connections.get(i).get(1);

            V.get(x).add(y);
        }

        int count = 0;
        for(int i=0; i<n;i++){
            if(visited[i]==false)
                findCycle(i, -1, count);
            count++;
        }

        // System.out.println(set);
        System.out.println(map);
        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> edge: connections){
            int x = edge.get(0);
            int y = edge.get(1);

            if(map.containsKey(x) && map.containsKey(y) && map.get(x) == map.get(y))
                continue;

            else{
                List<Integer> _ans = new ArrayList<>();

                _ans.add(x);
                _ans.add(y);

                ans.add(_ans);
            }
        }

        return ans;
    }

    public static boolean findCycle(int source, int parent, int count){
        List<Integer> curr = V.get(source);

        visited[source] = true;

        for(int child: curr){
            if(visited[child] == false){
                visited[child] = true;
                if(findCycle(child, source, count) == true) {
                    map.put(child, count);
                    map.put(source, count);
                    // set.add(child);
                    // set.add(source);

                    return true;
                }

            }else if(child != parent){
                map.put(child, count);
                if(parent != -1)
                    map.put(parent, count);
                return true;
            }
        }

        return false;
    }
}
