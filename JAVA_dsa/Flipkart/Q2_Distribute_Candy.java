package _dsa.Flipkart;

public class Q2_Distribute_Candy {
    public static void main(String[] args) {
        int arr[] = { 1,5,2, 1};

        int res = cal(arr, arr.length, -1, Integer.MAX_VALUE);
        System.out.println(res);
    }

    private static int cal(int[] arr, int n, int last, int res) {
        if(n == 0)
            return 0;

        int curr = -1;

        if(arr[n - 1] > last && last != -1)
            curr = last + 1;
        else
            curr = arr[n - 1];

        return curr + cal(arr, n - 1, arr[n - 1], res);
    }

}
