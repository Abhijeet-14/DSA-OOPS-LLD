package _dsa._15_12_21_practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class C2_K_Smallest_Elemet {
    public static void main(String[] args) {
        int arr[] = {7, 10, 20, 4, 5, 15};

        int k = 3;
        int res = solve(arr, k);
        System.out.println(res);
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
