package _dsa._4_2_22_Google.Sliding_Window;

import java.lang.reflect.Array;
import java.util.Arrays;

public class C4_count_occurrence_anagram {
    public static void main(String[] args) {
        String str = "roarfocnxroflfor";
        String ptn = "for";

        brute_force(str, ptn);
        gfg_approach(str, ptn);
    }

    public static void gfg_approach(String str, String ptn) {
        System.out.println("Sliding Window: TC-O(N+M) + AS-O(1)");
        // change CHARACTERS to support range of supported
        // characters
        int CHAR = 256;
        int n = str.length();
        int m = ptn.length();

        int count = 0;
        if(n < 0 || m < 0 || n < m)
            System.out.println(0);

        char[] pArr = new char[CHAR];
        char[] sArr = new char[CHAR];

        int i = 0;

        // till window size
        for(; i < m; i++) {
            sArr[CHAR - str.charAt(i)]++;
            pArr[CHAR - ptn.charAt(i)]++;
        }
        if(Arrays.equals(pArr, sArr))
            count += 1;

        // next window
        for(; i < n; i++) {
            sArr[CHAR - str.charAt(i)]++;
            sArr[CHAR - str.charAt(i - m)]--;

            if(Arrays.equals(pArr, sArr))
                count += 1;
        }
        System.out.println(count);
    }

    private static void brute_force(String str, String ptn) {
        System.out.println("Brute-Force:  T-CO(N*M) - AS-O(1)");
        int count = 0, n = str.length(), m = ptn.length();

        for(int i = 0; i < n - m + 1; i++) {
            String _str = str.substring(i, i + m);
            if(is_anagram(_str, ptn)) // O(M)
                count++;
        }

        System.out.println(count);
    }

    private static boolean is_anagram(String a, String b) {
        int CHAR = 26;
        int arr[] = new int[CHAR];

        for(char val : a.toCharArray())
            arr[val - 'a']++;

        for(char val : b.toCharArray())
            arr[val - 'a']--;

        for(int i = 0; i < CHAR; i++) {
            if(arr[i] != 0)
                return false;
        }

        return true;
    }
}
