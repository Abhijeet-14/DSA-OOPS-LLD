package _dsa._15_12_21_practice.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class C5_K_Closest_Number {
    public static void main(String[] args) {
        // sorted arr
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};

        int k = 4;
        int target = 35;

        System.out.println("Naive: O(NlogK)");
        solve_naive(arr, k, target);

        System.out.println("\n\nWe find crossover(1st greater element to X) then add k element");
        System.out.println("- Naive-2: O(N+k)");
        solve_naive_2(arr, k, target);


        System.out.println("- Optimize: O(logN+K)");
        solve_optimize(arr, k, target);
    }

    private static void solve_optimize(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        // immediate next;
        int idx = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + ((end - start) / 2);
            if(arr[mid] >= x) {
                idx = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        int crossover_r = idx;
        int crossover_l = idx - 1;
        if(arr[idx - 1] == x)
            crossover_l--;

        int count = 0;
        while(count < k && crossover_l >= 0 && crossover_r < arr.length) {
            if(arr[crossover_r] - x >= x - arr[crossover_l])
                res.add(arr[crossover_l--]);
            else
                res.add(arr[crossover_r++]);
            count++;
        }
        while(count < k && crossover_l >= 0) {
            res.add(arr[crossover_l--]);
            count++;
        }
        while(count < k && crossover_r < arr.length) {
            res.add(arr[crossover_r++]);
            count++;
        }

        System.out.println(res);
    }

    private static void solve_naive_2(int[] arr, int k, int x) {
        int crossover_l = -1;
        int crossover_r = arr.length;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                crossover_r = i + 1;
                crossover_l = i - 1;
                break;
            }
            if(arr[i] > x) {
                crossover_r = i;
                crossover_l = i - 1;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;
        while(count < k && crossover_l >= 0 && crossover_r < arr.length) {
            if(arr[crossover_r] - x >= x - arr[crossover_l])
                res.add(arr[crossover_l--]);
            else
                res.add(arr[crossover_r++]);
            count++;
        }
        while(count < k && crossover_l >= 0) {
            res.add(arr[crossover_l--]);
            count++;
        }
        while(count < k && crossover_r < arr.length) {
            res.add(arr[crossover_r++]);
            count++;
        }

        System.out.println(res);
    }

    private static void solve_naive(int[] arr, int k, int x) {

        // max-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> -a.diff + b.diff);

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != x) {
                pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
                if(pq.size() > k)
                    pq.poll();
            }
        }

        for(Pair p : pq)
            System.out.print(p.val + " ");
    }

    static class Pair {
        int diff;
        int val;

        public Pair(int diff, int val) {
            this.diff = diff;
            this.val = val;
        }


    }
}
