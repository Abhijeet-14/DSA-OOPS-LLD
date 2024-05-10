package _dsa._0_LeetCode_Village.__Revision;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        System.out.println(binarySearch(arr,0,arr.length-1, 7));
    }

    private static int binarySearch(int arr[], int left, int right, int x){
        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid] > x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }
}
