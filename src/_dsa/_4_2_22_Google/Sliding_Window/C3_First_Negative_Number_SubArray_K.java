package _dsa._4_2_22_Google.Sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class C3_First_Negative_Number_SubArray_K {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};

        brute_force(k, arr);
        sliding_window(k, arr);
    }

    private static void sliding_window(int k, int[] arr) {
        System.out.println("Sliding Window - TC-O(N) AS-O(N)");
        List<Integer> list = new ArrayList<>();

        int left = 0, right = 0, t = 0;
        while(right < arr.length) {
            if(arr[right] < 0)
                list.add(arr[right]);

            if(right - left + 1 < k)
                right++;

            else if(right - left + 1 == k) {
                if(t>=list.size())
                    System.out.print(0 + " ");
                else {
                    System.out.print(list.get(t) + " ");

                    if(arr[left] == list.get(t))
                        t++;
                }
                left++;
                right++;
            }

        }
    }

    private static void brute_force(int k, int[] arr) {
        System.out.println("Brute-Force - TC-O(N*k) AS-O(1)");

        for(int i = 0; i < arr.length - k + 1; i++) {
            boolean flag = false;
            for(int j = 0; j < k; j++) {
                if(arr[i + j] < 0) {
                    System.out.print(arr[i + j] + " ");
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                System.out.println(0 + " ");
            else
                flag = false;
        }
    }
}
