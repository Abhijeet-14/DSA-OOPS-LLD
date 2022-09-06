package ___KT_C3;

public class VVI_KeepTruckin_Coding_2 {
    public static void main(String[] args) {

//        System.out.println("\nWith finding Pivot O(logN)");
//        solve_method_1_pivot(new int[]{0,1,2,3,4,5}, 5);
//        solve_method_1_pivot(new int[]{10,12,0,2,4,5,6,8}, 6);
//        solve_method_1_pivot(new int[]{2,4,6,7,8,0,1}, 7);
//        solve_method_1_pivot(new int[]{4,5,6,7,0,1,2}, 0);

        System.out.println("\nWithOut Pivot O(logN)");
//        solve_method_2_wo_pivot(new int[]{0,1,2,3,4,5}, 5);
        solve_method_2_wo_pivot(new int[]{10,12,0,2,4,5,6,8}, 6);
//        solve_method_2_wo_pivot(new int[]{2,4,6,7,8,0,1}, 7);
//        solve_method_2_wo_pivot(new int[]{4,5,6,7,0,1,2}, 0);
    }

    private static void solve_method_1_pivot(int[] arr, int X) {

        int pivot = findPivot(arr);


        if(pivot != -1){
            int idx = -1;
            if(arr[0]< X && arr[pivot] > X)
                idx = binarySearch_2(arr,0, pivot, X);
            else
                idx = binarySearch_2(arr, pivot, arr.length-1, X);

            System.out.println("result: " + idx);

        }
        else {
            int idx = binarySearch_2(arr, pivot, arr.length - 1, X);
            System.out.println("result(Can't find Pivot): " + idx);
        }
    }

    private static int findPivot(int[] arr) {

        int left=0, right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;

            int next= (mid+1)%arr.length;
            int prev= (arr.length + mid-1)%arr.length;

            if(arr[mid]>=next && arr[mid]>=prev){
                return mid;
            }
            else if(arr[mid]>arr[right])
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }

    public static int binarySearch_2(int arr[], int left, int right, int x){

        while(left<=right){
            int mid = left + ((right-left)/2);

            if(arr[mid]==x){
                return mid;
            }

            else if(arr[mid] > x){
                right = mid-1;
            }
            else
                left = mid+1;
        }

        return -1;
    }

    private static void solve_method_2_wo_pivot(int[] arr, int x) {
        System.out.println("Result(wo pivot): " + binarySearch(arr, 0, arr.length-1, x));
    }

    public static int binarySearch(int arr[], int left, int right, int x){


        while(left<=right){
            int mid = (left +right)/2;//+ ((right-left)/2);

            if(arr[mid]==x){
                return mid;
            }


            else if(arr[mid]>=arr[left]){ // Is BS?
                if(arr[left]<=x && arr[mid]>= x)
                    right = mid-1;
                else
                    left = mid+1;
            }
            else if(arr[mid]<=arr[right]){ // Is BS?
                if(arr[right]>=x && arr[mid]<= x) // if fall in [mid, right]
                    left = mid+1;
                else
                    right = mid-1;
            }
        }

        return -1;
    }

}
