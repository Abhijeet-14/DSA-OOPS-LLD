package _dsa._9_1_22_Practice.BinarySearch;

public class C1_BS {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 7, 9, 23};
        int resultI = binarySearch(arr, 17);
        System.out.println("Index: " + resultI);
    }

    private static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + ((end - start) / 2);

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
