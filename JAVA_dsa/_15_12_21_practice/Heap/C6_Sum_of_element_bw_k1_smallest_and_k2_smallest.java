package _dsa._15_12_21_practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class C6_Sum_of_element_bw_k1_smallest_and_k2_smallest {
    public static void main(String[] args) {
        int arr[] = {7, 10, 20, 4, 5, 15};

        int k1 = 2;
        int k2 = 5;
        int first = solve(arr, k1);
        int sec = solve(arr, k2);

        int sum = 0;
        for(int val : arr) {
            if(val > first && val < sec)
                sum += val;
        }
        System.out.println("Sum: " + sum + " first: " + first + " second: " + sec);

    }

    private static int solve(int[] arr, int k) {
        // Max-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}