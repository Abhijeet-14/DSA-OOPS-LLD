package _dsa._0__Revision;

public class BS_Immediate_Next_Prev {
    public static void main(String[] args) {
        int arr[] = {2,3,7,9,10};

        int n = arr.length;

        int target = 8;

        int res_basic = bs_basic(arr, n, target);
        System.out.println("Not able to Find " + target + " : " + res_basic);

        int res_next = bs_imm_next(arr,n, target);
        System.out.println("Immediate Next to " + target + " : " + arr[res_next]);

        int res_prev = bs_imm_prev(arr,n, 4);
        System.out.println("Immediate Next to " + target + " : " + arr[res_prev]);
    }

    private static int bs_basic(int[] arr, int n, int x) {
        int start = 0;
        int end = n-1;
        
        while(start<=end){
            int mid = (start+end)/2;

            if( arr[mid] == x)
                return mid;

            else if(arr[mid]< x)
            {
                start = mid +1;
            }
            else{
                end =mid-1;
            }
        }

        return -1;
    }

    private static int bs_imm_next(int[] arr, int n, int x) {
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


    private static int bs_imm_prev(int[] arr, int n, int x) {
        int start = 0;
        int end = n-1;
        int res = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]<= x)
            {
                start = mid +1;
                res = mid;
            }
            else{
                end =mid-1;
            }
        }

        return res;
    }

}
