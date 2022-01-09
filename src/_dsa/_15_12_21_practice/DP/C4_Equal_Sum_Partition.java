package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C4_Equal_Sum_Partition {
    static int arr[] = {1, 5, 11, 5};

    public static void main(String[] args) {
        int n = arr.length;
        int total_sum = Arrays.stream(arr).sum();

        // similar to sub-set sum
        if(total_sum % 2 != 0)
            System.out.println("Result: " + false);
        else {
            boolean result = equal_sum(total_sum / 2, n);
            System.out.println("Result: " + result);
        }

    }

    private static boolean equal_sum(int sum, int n) {

        // base condition
        if(sum == 0)
            return true;

        if(n == 0 && sum != 0)
            return false;

        // rule
        if(arr[n - 1] <= sum)
            return equal_sum(sum - arr[n - 1], n - 1) || equal_sum(sum, n - 1);

        return equal_sum(sum, n - 1);
    }
}
