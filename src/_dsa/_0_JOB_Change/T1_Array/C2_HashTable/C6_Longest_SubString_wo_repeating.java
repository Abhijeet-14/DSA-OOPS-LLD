package _dsa._0_JOB_Change.T1_Array.C2_HashTable;

import java.util.*;

public class C6_Longest_SubString_wo_repeating {
    public static void main(String[] args) {
        String s = "awaf";

        int ans_brute_force = lengthOfLongestSubstring_brute_force(s);
        System.out.println(ans_brute_force);

        int ans_hash_map = lengthOfLongestSubstring_Hash_Map(s); // O(N)
        System.out.println(ans_hash_map);
    }

    public static int lengthOfLongestSubstring_brute_force(String s) {
        System.out.println("Pending!!");
        return -1;
    }
    public static int lengthOfLongestSubstring_Hash_Map(String s) {
        int len = s.length();
        if(len<2)
            return len;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;

        for(int i=0; i<len;){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                max = Math.max(max,count);
                count = 0;
                i = map.get(curr)+1; // O(1)
                map = new HashMap<>();
            }
            else{
                map.put(curr, i); // O(1)
                count++;
                i++;
            }
        }

        max = Math.max(count, max);
        return max;
    }
}
