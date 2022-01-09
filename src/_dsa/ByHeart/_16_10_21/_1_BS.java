package _dsa.ByHeart._16_10_21;

public class _1_BS {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 4, 5, 6, 7, 0, 1 };
		int target = 4;

		int result = binarySearch(arr, 0, arr.length - 1, target);

		System.out.println("\n" + result);

	}

	public static int binarySearch(int arr[], int start, int end, int target) {

		while (start <= end) {
			int mid = start + ((end - start) / 2);

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}
