package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C5_Kadene_Algorithm {
    public static void main(String[] args) {
         int arr[] = {-5,4,6,-3,4,-1};
        // all negative
//        int arr[] = {-10,-10,-10};

        int ans_brute_force = solve_brute_force(arr);
        System.out.println("Brute_Force: " + ans_brute_force);

        // PROBLEM: need to find the maximum sub_array
        int ans = solve_kadane_algo(arr);
        System.out.println("Kadane Algo: " + ans);

        int ans_all_negative = solve_ans_all_negative(arr);
        System.out.println("All Negative: " + ans_all_negative);
    }

    private static int solve_brute_force(int[] arr) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            int curr_sum = 0;
            for(int j=i;j<len;j++) {
                curr_sum += arr[j];
                max = Math.max(max, curr_sum);
            }
        }

        return max;
    }

    private static int solve_kadane_algo(int[] arr) {
        // Logic:
        // we do sum of each element - curr_sum
        // after each sum max = Math.max(max, curr_sum)
        // if curr_sum < 0 -> curr_sum = 0

        int len = arr.length;

        int max = Integer.MIN_VALUE;

        int curr_sum = 0;
        for(int i=0; i<len; i++){
            curr_sum += arr[i];

            if(curr_sum>max)
                max = Math.max(curr_sum, max);
            if(curr_sum<0)
                curr_sum = 0;

        }

        return max;
    }

    private static int solve_ans_all_negative(int[] arr) {
        int len = arr.length;
        int negative_count = 0;
        for(int i=0; i<len;i++){
            if(arr[i]<0)
                negative_count++;
        }

        int max = Integer.MIN_VALUE;
        if(negative_count == len){
            for(int i=0; i<len;i++)
                max = Math.max(arr[i], max);
        }

        return max;
    }
}
