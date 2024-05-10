package _dsa._15_12_21_practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class C4_Sort_K_Sorted_array {
    public static void main(String[] args) {

        // 0th-element can present in 0-3
        // 4th-element can present in 0-3 or 5-8
        // at i -> can be present k-times + or -
        int arr[] = {6, 5, 3, 2, 8, 10, 9};

        int k = 3;
        int[] res = solve(arr, k);
        System.out.println("Result: ");
        for(int val : res)
            System.out.print(val + " ");
    }

    private static int[] solve(int[] arr, int k) {
        // Max-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res[] = new int[arr.length];

        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                res[j++] = pq.poll();
            }
        }

        while(!pq.isEmpty())
            res[j++] = pq.poll();
        return res;
    }
}
