package _dsa.ByHeart._8_11_21;

public class _1BS {
    public static void main(String[] args) {
        int arr[ ] = new int[]{1,2,3,4,4,4,5,7};
        int target  = 4;

        int res = binarySearch(0, arr.length-1, arr, target);
        System.out.println("Result: " + res);
    }

    private static int  binarySearch(int start, int end, int arr[], int target) {
        int res = -1;

        while(start<=end){
            int mid = start + (end-start/2);
            if (arr[mid] == target){
                res= mid;
                start = mid+1;
            }
            else if (arr[mid] > target)
                end = mid -1;
            else
                start = mid+1;
        }

        return res;
    }
}
