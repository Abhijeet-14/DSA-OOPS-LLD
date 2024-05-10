package _dsa.ByHeart._16_10_21;

public class _2_MergeSort {

    public static void main(String[] args) {
        int arr[] = {1, 4, 7, 9, 2, 3, 5};
        mergeSort(arr, arr.length);
        printArr(arr);
    }


    public static void mergeSort(int[] a, int n) {
        if(n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid]; // left arr
        int[] r = new int[n - mid]; //right arr

        for(int i = 0; i < mid; i++) { // map
            l[i] = a[i];
        }
        for(int i = mid; i < n; i++) { // map
            r[i - mid] = a[i];
        }
        mergeSort(l, mid); // divide left
        mergeSort(r, n - mid); // divide right

        merge(a, l, r, mid, n - mid); // sort arr
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while(i < left && j < right) {
            if(l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while(i < left) {
            a[k++] = l[i++];
        }
        while(j < right) {
            a[k++] = r[j++];
        }
    }

    private static void printArr(int a[]) {
        System.out.print("[ ");
        for(int val : a) {
            System.out.print(val + ", ");
        }
        System.out.print("]");
    }

}