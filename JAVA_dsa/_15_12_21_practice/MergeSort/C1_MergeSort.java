package _dsa._15_12_21_practice.MergeSort;

public class C1_MergeSort {
    public static void main(String[] args) {
        int arr[] = {6, 2, 3, 1, 9, 0};

        // merge 2 sorted array
        int a[] = {10, 3, 20, 5, 15, 6, 17};

        divide2Arr(a);
        printArr(a);
    }

    private static void divide2Arr(int[] arr) {
        int N = arr.length;
        if(N < 2)
            return;

        int mid = N / 2;

        int left[] = new int[mid];
        int right[] = new int[N - mid];
        for(int i = 0; i < mid; i++)
            left[i] = arr[i];

        for(int j = mid; j < N; j++)
            right[j - mid] = arr[j];

        divide2Arr(left);
        divide2Arr(right);

        merge2Arr(left, right, arr);
    }

    private static void merge2Arr(int a[], int b[], int c[]) {
        int n = a.length;
        int m = b.length;

        int ia = 0, ib = 0, k = 0;
        while(ia < n && ib < m) {
            if(a[ia] <= b[ib]) {
                c[k] = a[ia];
                ia++;
            } else {
                c[k] = b[ib];
                ib++;
            }
            k++;
        }

        while(ia < n) {
            c[k++] = a[ia++];
        }

        while(ib < m) {
            c[k++] = b[ib++];
        }
    }

    private static void printArr(int arr[]) {
        for(int val : arr) {
            System.out.print(val + ", ");
        }
    }
}
