package _dsa._4_2_22_Google.Sliding_Window;

public class C6_largest_SubArray_Of_Sum_k {
    public static void main(String[] args) {
        int sum = 5;
        int arr[] = {4, 1, 1, 1, 1, 3, 5};

        brute_force(arr, sum);
        sliding_window(arr, sum);
    }

    private static void sliding_window(int[] arr, int sum) {
        System.out.println("\nSliding_Window: TC-O(N) AS-O(1)");
        int l = 0, r = 0, n = arr.length;
        int res = 0, curr_sum = 0;

        while(r < n) {
            curr_sum += arr[r];
            if(curr_sum > sum) {
                curr_sum -= arr[l] + arr[r];
                l++;
            } else if(curr_sum == sum) {
                res = Math.max(res, r - l + 1);
                curr_sum -= arr[l];
                l++;
                r++;
            } else
                r++;
        }
        System.out.println(res);
    }

    private static void brute_force(int[] arr, int sum) {
        System.out.println("\nBrute-force: TC-O(N^2) AS-O(1)");
        int n = arr.length;

        int res = 0;
        for(int i = 0; i < n; i++) {
            int curr_sum = 0;
            for(int j = i; j < n; j++) {
                curr_sum += arr[j];
                if(curr_sum > sum)
                    break;
                if(curr_sum == sum) {
                    res = Math.max(j - i + 1, res);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
