package _dsa._0__Revision;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {3,8,4,9,6,1};

        // 2 Step:
        // 1. divide arr
        // 2. merge
        divideArr(arr);

        for(int val: arr)
            System.out.print(val + " ");

    }

    private static void divideArr(int arr[]){
            int len = arr.length;

            if (len<2)
                return;

            int mid = len/2;

            int left[] = new int[mid];
            int right[] = new int[len-mid];

            for(int i=0; i<mid; i++)
                left[i] = arr[i];

            for(int j=mid; j<len; j++)
                right[j-mid] = arr[j];

            divideArr(left);
            divideArr(right);

            merge2Arr(left, right, arr);
    }

    private static void merge2Arr(int left[], int right[], int currArr[]){
        int l=0,r=0, index = 0;
        int n = left.length, m = right.length;

        while(l<n && r<m){
            if(left[l]<right[r])
                currArr[index++] = left[l++];
            else
                currArr[index++] = right[r++];
        }

        while(l<n)
            currArr[index++] = left[l++];

        while(r<m)
            currArr[index++] = right[r++];

    }

}
