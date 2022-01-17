package _dsa._15_12_21_practice.MCM_DP;

public class C1_Intro {
    // Identify?
    // String or Array
    // i - j  & i<k<j
    // we need to divide to i->k & k+1->j
    // So, MCM work here

    // e.g.,  solve([0,1,2,3,4,5])
    // t1= solve([0,1,2]) & t2=solve([3,4,5])
    // fun(t1, t2) -> Final ANSWER

    // So, conditions:
    // 1. String or Array
    // 2. divide into 2 part
    // 3. combine result of Sub-Array give -> Final Result
    public static void main(String[] args) {

    }

    private int solve(int arr[], int i, int j) {
        // BASE CONDITION
        if(i > j)
            return 0;

        int ans = 0;
        for(int k = i; k < j; k++) {
            // temp1
            solve(arr, i, k);
            // temp2
            solve(arr, k + 1, j);

            // ans = function(temp1, temp2)
        }
        return ans;
    }
}
