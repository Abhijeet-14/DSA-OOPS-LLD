package _dsa._15_12_21_practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class C3_return_k_largest_element {
    public static void main(String[] args) {
        int arr[] = {7, 10, 20, 4, 5, 15};

        int k = 3;
        int res[] = solve(arr, k);
        for(int val: res)
            System.out.print(val + " ");
    }

    private static int[] solve(int[] arr, int k) {
        // Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int _arr[] = new int[k];

        int i = 0;
        while(!pq.isEmpty())
            _arr[i++] = pq.poll();

        return _arr;
    }
}
