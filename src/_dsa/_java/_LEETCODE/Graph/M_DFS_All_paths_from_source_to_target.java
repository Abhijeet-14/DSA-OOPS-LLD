package _dsa._java._LEETCODE.Graph;

import java.util.*;

// Question: https://leetcode.com/problems/all-paths-from-source-to-target/submissions
// Response: Not Solved :(

public class M_DFS_All_paths_from_source_to_target {

	public static void main(String[] args) {
		int graph[][] = {{4,3,1},{3,2,4},{3},{4},{}};
		
		System.out.println(allPathsSourceTarget(graph));	
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, graph.length - 1, path, res);
        return res;
    }
    
    private static void dfs(int[][] graph, int node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, target, path, res);
            path.remove(path.size() - 1);
        }
    }

}
