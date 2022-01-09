package _dsa._15_12_21_practice.BinarySearch;

public class BS_Immediate_Next {
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};

        int n = arr.length;

        int res = bs_in(arr,n, 4);
        System.out.println(res);
    }

    private static int bs_in(int[] arr, int n, int x) {
        int start = 0;
        int end = n-1;
        int res = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]<= x)
            {
                start = mid +1;
            }
            else{
                res = mid;
                end =mid-1;
            }
        }

        return res;
    }

}
