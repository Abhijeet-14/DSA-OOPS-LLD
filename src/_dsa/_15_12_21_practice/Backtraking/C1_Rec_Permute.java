package _dsa._15_12_21_practice.Backtraking;

// ABC -> permutation which don't contain "AB"
public class C1_Rec_Permute {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();

        String notStr = "AB";

        permute(str, notStr, 0, n - 1);
    }

    private static void permute(String str, String notStr, int l, int r) {
        if(l == r) {
            if(!str.contains(notStr))
                System.out.println(str);
            return;
        }
        for(int i = l; i <= r; i++) {
            str = swap(str, i, l);
            permute(str, notStr, l + 1, r);
            str = swap(str, i, l);
        }
    }

    private static String swap(String str, int i, int l) {
        char[] arr = str.toCharArray();

        char temp = arr[i];

        arr[i] = arr[l];
        arr[l] = temp;

        String newStr = String.valueOf(arr);

        return newStr;
    }
}
