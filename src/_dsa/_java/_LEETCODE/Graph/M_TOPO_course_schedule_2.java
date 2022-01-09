package _dsa._java._LEETCODE.Graph;

// Quesiton: https://leetcode.com/problems/course-schedule-ii/submissions/

// response: SOLVED

import java.util.*;

public class M_TOPO_course_schedule_2 {

    public static void main(String[] args) {

        int numCourses = 5;
        int[][] prerequisites = { { 0, 1 }, { 2, 4 }, { 3, 4 }, { 1, 3 }, { 2, 3 } };

        int res[] = findOrder(numCourses, prerequisites);

        for (int val : res)
            System.out.print(" " + val);

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        boolean visited[] = new boolean[numCourses];
        boolean recSt[] = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];

            adj.get(x).add(y);
        }

        boolean isCycle = false;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i])
                if (detectCycle(adj, visited, recSt, i) == true)
                    isCycle = true;
        }

        if (isCycle) {
            int res[] = new int[0];
            return res;
        } else {
            Arrays.fill(visited, false);

            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    dfsTopo(adj, visited, s, i);
                }
            }

            int val[] = s.stream().mapToInt(i -> i).toArray();

            return val;
        }
    }

    public static void dfsTopo(List<List<Integer>> adj, boolean visited[], Stack<Integer> s, int source) {
        List<Integer> curr = adj.get(source);
        visited[source] = true;

        for (int i = 0; i < curr.size(); i++) {
            int child = curr.get(i);

            if (!visited[child]) {
                dfsTopo(adj, visited, s, child);
            }
        }

        s.push(source);
    }

    public static boolean detectCycle(List<List<Integer>> adj, boolean visited[], boolean recSt[], int source) {
        List<Integer> curr = adj.get(source);
        visited[source] = true;
        recSt[source] = true;

        for (int i = 0; i < curr.size(); i++) {
            int child = curr.get(i);

            if (!visited[child]) {
                if (detectCycle(adj, visited, recSt, child) == true)
                    return true;
            } else if (recSt[child] == true)
                return true;
        }

        recSt[source] = false;

        return false;
    }
}
