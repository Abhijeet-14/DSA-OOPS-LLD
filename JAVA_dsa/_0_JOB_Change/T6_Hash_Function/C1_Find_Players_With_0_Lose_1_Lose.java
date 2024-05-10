package _dsa._0_JOB_Change.T6_Hash_Function;
import java.util.*;

public class C1_Find_Players_With_0_Lose_1_Lose {
    // Question: https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    public static void main(String[] args) {

    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> m1 = new TreeMap<>();
        Map<Integer, Integer> m2 = new TreeMap<>();

        for(int i=0; i<matches.length;i++){
            int win = matches[i][0];
            int lose = matches[i][1];

            m1.put(win, m1.getOrDefault(win,0) + 1);
            m2.put(lose, m2.getOrDefault(lose,0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();

        for(int key: m2.keySet()){
            if(m2.get(key) == 1)
                s2.add(key);
        }

        for(int key: m1.keySet()){
            if(!m2.containsKey(key))
                s1.add(key);
        }

        ans.add(new ArrayList<>(s1));
        ans.add(new ArrayList<>(s2));

        return ans;
    }
}
