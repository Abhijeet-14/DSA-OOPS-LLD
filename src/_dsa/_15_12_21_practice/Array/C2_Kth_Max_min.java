package _dsa._15_12_21_practice.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class C2_Kth_Max_min {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int n = arr.length;
        int k = 3;

        int res = solve(arr, k, n);
        System.out.println(res + " O(nlogn)");
    }

    private static int solve(int[] arr, int k, int n) {
        if(n < k)
            return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {

            if(pq.size() < k)
                pq.add(arr[i]);
            else {
                int curr = pq.peek();
                if(arr[i] < curr) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        return pq.remove();
    }

    static class Pair {
        int min, max;

        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}
