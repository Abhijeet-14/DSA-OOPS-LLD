package _dsa._9_1_22_Practice.MergeSort;

public class C1_MergeSort {
    public static void main(String[] args) {
        int arr[] = {10, 5, 30, 15, 7};

        divide2Arr(arr);

        for(int val : arr)
            System.out.print(val + ", ");
    }

    private static void divide2Arr(int[] arr) {
        int N = arr.length;
        if(N < 2)
            return;

        int mid = N / 2;

        int[] left = new int[mid];
        int right[] = new int[N - mid];

        for(int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for(int i = mid; i < N; i++) {
            right[i - mid] = arr[i];
        }

        divide2Arr(left);
        divide2Arr(right);

        merge2Arr(left, right, arr);
    }

    private static void merge2Arr(int[] left, int[] right, int[] arr) {
        int n = left.length, m = right.length;
        int l = 0, r = 0, index = 0;

        while(l < n && r < m) {
            if(left[l] <= right[r])
                arr[index++] = left[l++];
            else
                arr[index++] = right[r++];
        }

        // if left - remains
        while(l < n)
            arr[index++] = left[l++];

        while(r < m)
            arr[index++] = right[r++];
    }
}
