package _dsa._java._LEETCODE.Dynamic_Programing;

/*
 * Question: https://leetcode.com/problems/count-sorted-vowel-strings/
 * 
 * Response: SOLVED, but needs DP optimization
 * 
 * Optimization: DP approach
 */
public class M1_VERY_IMP_Count_Sorted_Vowel_Strings {

    public static void main(String[] args) {
        int n = 2;

        int ans = myApproach(n);
        System.out.println("MyApproach: 5%, 700ms \n" + ans);

        int dpAns = optimize(n);
        System.out.println("\nOptmize: 100%, 0ms O(n) \n" + dpAns);

        int dpAns2 = optimize2(n);
        System.out.println("\nOptmize2: 100%, 0ms O(n) \n" + dpAns2);
    }

    ///////////////////////////////////////////////////////////////////
    // OPTIMIZATION 1
    ///////////////////////////////////////////////////////////////////

    // if we know all the string of length k, so the string of length k + 1 will be
    // 1. add a before all string of length k
    // 2. add e before the string of length k, which is starts with or after e
    // 3. add i before the string of length k, which starts with or after i
    // 4. add o before the string of length k, which starts with or after o
    // 5. add u before the string of length k, which starts with or after u
    private static int optimize(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while (n > 1) {
            // add new char before previous string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u + 0); // u -> uu
            n--;
        }

        return a + e + i + o + u;
    }

    ///////////////////////////////////////////////////////////////////
    // OPTIMIZATION 2
    ///////////////////////////////////////////////////////////////////

    public static int optimize2(int n) {
        Integer[][] memo = new Integer[n + 1][5];
        return dp(n, 0, memo);
    }

    public static int dp(int n, int i, Integer memo[][]) {
        if (n == 0)
            return 1; // Found a valid answer
        if (i == 5)
            return 0; // Reach to length of vowels [a, e, i, o, u]

        if (memo[n][i] != null)
            return memo[n][i];

        // Skip vowels[i] // Include vowels[i]
        int ans = dp(n, i + 1, memo) + dp(n - 1, i, memo);

        return memo[n][i] = ans;
    }

    ///////////////////////////////////////////////////////////////////
    // MY-APPROACH
    ///////////////////////////////////////////////////////////////////
    static char vow[] = new char[] { 'a', 'e', 'i', 'o', 'u' };
    static int count = 0;

    public static int myApproach(int n) {
        for (int j = 0; j < 5; j++)
            solve(n, 1, 0, String.valueOf(vow[j]));

        return count;
    }

    public static void solve(int n, int i, int j, String word) {
        if (i == n) {
            count++;
            return;
        }

        if (j >= 5)
            return;

        if (word.charAt(word.length() - 1) <= vow[j]) {
            // here, j doesn't change bcoz
            // this character is added .. and again for next letter
            // we iterate thro same index
            // word = a, new word = aa... for next time again start from a.. and results
            // word aaa.
            solve(n, i + 1, j, word + vow[j]);
        }

        solve(n, i, j + 1, word);
    }

}
