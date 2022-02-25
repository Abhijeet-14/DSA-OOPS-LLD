package _dsa._4_2_22_Google.Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class C5_Sliding_Window_Maximum {
    // also: Maximum of all sub-array of size k
    public static void main(String[] args) {
        System.out.println("\nVery very Important Problem");
        int k = 3;
        int arr[] = {1, 3, -1, 2, 1, 3, 6, 7};

        brute_force(k, arr);
        sliding_window(k, arr);
    }

    private static void sliding_window(int k, int[] arr) {

        System.out.println("\nSliding_Window: TC-O(N) AS-O(N), use DEQUE");

        Deque<Integer> dq = new ArrayDeque<>();

        int l = 0, r = 0,n = arr.length;;

        List<Integer> res = new ArrayList<>();


        while(r < n) {
            while(!dq.isEmpty() && dq.getLast()<arr[r]){
                dq.pollLast();
            }
            dq.addLast(arr[r]);

            if(r - l + 1 == k) {
                res.add(dq.getFirst());
                if(dq.getFirst() == arr[l])
                    dq.pollFirst();
                l++;
            }
            r++;
        }

        System.out.println(res);

    }

    private static void brute_force(int k, int[] arr) {
        System.out.println("\nBrute-Force: TC-O(N*K) AS-O(1)");
        int n = arr.length;

        for(int i = 0; i < arr.length - k + 1; i++) {
            int mx = Integer.MIN_VALUE;
            for(int j = 0; j < k; j++) {
                mx = Math.max(mx, arr[i + j]);
            }
            System.out.print(mx + " ");
        }
    }
}
