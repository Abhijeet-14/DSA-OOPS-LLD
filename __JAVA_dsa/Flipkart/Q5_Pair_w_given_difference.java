package _dsa.Flipkart;

public class Q5_Pair_w_given_difference {
    public static void main(String[] args) {
        int arr[] = {5, 10, 3, 2, 50, 80};
        int target = 53;

        int i = 0, j = arr.length - 1;
        while(i <= j) {
            int pairP = arr[i] + arr[j];
            int pairM = Math.abs(arr[i] - arr[j]);
            if(pairP == target || pairM == Math.abs(target)) {
                System.out.println("Possible: " + i + " " + j);
                break;
            } else if(pairP > target && pairM > target) {
                j--;
            } else
                i++;
        }


    }
}
