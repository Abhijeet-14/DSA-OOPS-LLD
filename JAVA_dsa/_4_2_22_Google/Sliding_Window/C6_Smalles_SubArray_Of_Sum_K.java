package _dsa._4_2_22_Google.Sliding_Window;

public class C6_Smalles_SubArray_Of_Sum_K {
    public static void main(String[] args) {
        int target = 7;
        int arr[] = {2, 3, 1, 2, 4, 3};

        int res_BF = bruteForce(target, arr);
        System.out.println("Res_BF: " + res_BF + " => TC-O(N^2) AS-O(N)");

        int res_optimize = SlidingWindow(target, arr);
        System.out.println("Res_SW: " + res_optimize + " => TC-O(N) AS-O(1)");
    }

    public static int SlidingWindow(int x, int[] arr) {
        int l = 0, r = 0, sum = 0;

        int res = Integer.MAX_VALUE;

        while(r < arr.length) {
            sum += arr[r];

            if(sum >= x) {
                sum = sum - arr[l] - arr[r];
                res = Math.min(res, r - l + 1);
                l++;
            } else
                r++;
        }

        if(res == Integer.MAX_VALUE)
            return 0;

        return res;
    }

    private static int bruteForce(int x, int[] arr) {
        int n = arr.length;
        if(n == 0)
            return 0;

        int ans = Integer.MAX_VALUE;

        int[] sums = new int[n];

        sums[0] = arr[0];

        for(int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + arr[i];

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + arr[i];
                if(sum >= x) {
                    ans = Math.min(ans, (j - i + 1));
                    break; // Found the smallest sub-array with sum>=x starting with index i, hence move to next index
                }
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
