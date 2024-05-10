package _dsa._4_2_22_Google.Sliding_Window;

import java.net.Socket;

public class C2_Max_Min_SubArray_of_size_K {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2, 5, 1, 8, 2, 9, 1};

        brute_force(k, arr);
        sliding_window(k, arr);
    }

    private static void sliding_window(int k, int[] arr) {
        System.out.println("\nSLIDING-WINDOW TC-O(N) AS-O(1)");
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int sum = 0;

        while(right < arr.length) {
            sum += arr[right];

            if(right >= k) {
                sum += -arr[left];
                left++; // we increase 'left', after subs from SUM.
            }

            if(right - left + 1 == k) {
                mx = Math.max(mx, sum);
                mn = Math.min(mn, sum);
            }
            right++;
        }
        System.out.println("Max_SW: " + mx);
        System.out.println("Min_SW: " + mn);
    }

    private static void brute_force(int k, int[] arr) {
        System.out.println("\nBRUTE-FORCE TC-O(N^2) AS-O(N)");

        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - k; i++) {
            int sum = 0;

            for(int j = 0; j < k; j++)
                sum += arr[i + j];

            mx = Math.max(mx, sum);
            mn = Math.min(mn, sum);
        }

        System.out.println("Max_BF: " + mx);
        System.out.println("Min_BF: " + mn);
    }
}
