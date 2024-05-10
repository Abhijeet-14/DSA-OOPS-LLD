package _dsa._15_12_21_practice.DP;

public class C1_Fibo {
    public static void main(String[] args) {
//        0 1 1 2 3 5 8

        int n = 5;
      // fibo recursion
      int ans_rec = fibo_rec(n);
      System.out.println("Ans_Rec: " + ans_rec);

      // fibo memoization
        int t[] = new int[n+1];
      int ans_memo = fibo_memo(n, t);
      System.out.println("Ans_Memo: " + ans_memo);

      // fibo tabulation
      int ans_tabu = fibo_tabu(n);
      System.out.println("Ans_Tabu: " + ans_tabu);
    }

    static int fibo_rec(int n){
        if(n == 0 || n == 1)
            return n;

        return fibo_rec(n-1) + fibo_rec(n-2);
    }

    static int fibo_memo(int n, int t[]){
        if(n == 0 || n ==1)
            return n;

        if(t[n]!=0)
            return t[n];

        return t[n] = fibo_memo(n-1, t) + fibo_memo(n-2, t);
    }

    static int fibo_tabu(int n){
        int dp [] = new int[n+1];

        for(int i=0; i<n+1; i++){
            if(i<=1)
                dp[i]=i;
            else
                dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

