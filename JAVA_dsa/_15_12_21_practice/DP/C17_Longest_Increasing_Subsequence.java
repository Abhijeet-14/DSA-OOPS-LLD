package _dsa._15_12_21_practice.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C17_Longest_Increasing_Subsequence {

    static int t[];

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        t = new int[arr.length];


//        int dp[] = new int[arr.length];
//        int res = lis_1(arr, arr.length, dp);
//        System.out.println(res);
        int res_1 = lis_2(arr, arr.length);
        System.out.println();
        System.out.println(res_1);
    }

    private static int binarySearch(List<Integer> arr, int start, int end, int x) {

        int res = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr.get(mid) <= x) {
                start = mid + 1;
            } else {
                res = mid;
                end = mid - 1;
            }
        }

        return res;
    }

    private static int lis_2(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();

        temp.add(arr[0]);

        for(int i = 1; i < n; i++) {
            if(arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            } else {
                int index = binarySearch(temp, 0, temp.size() - 1, arr[i]);
                temp.set(index, arr[i]);
            }
        }

        for(int val : temp)
            System.out.print(val + " ");
        return temp.size();
    }

    private static int lis_1(int[] arr, int n, int dp[]) {
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        int mx = 1;
        for(int val : dp)
            mx = Math.max(mx, val);

        return mx;
    }
}
