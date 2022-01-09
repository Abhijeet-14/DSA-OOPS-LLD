package _dsa._15_12_21_practice.Backtraking;

public class C2_BackTrack_Permute {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();

        String notStr = "AB";

        permute_BT(str, notStr, 0, n - 1);
    }


    private static boolean isSafe(String str, int l, int r, int i) {
        // if prev-char is 'A' & curr-char is 'B', then
        // DON'T proceed & CUT-DOWN
        if(l != 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B')
            return false;

        // When last 2 char is 'BA'
        // Don't swap and make it 'AB'
        if(r == l + 1 && str.charAt(l) == 'B' && str.charAt(i) == 'A') {
            return false;
        }

        // when last 2 char is 'AB' & l == i
        // r = 'B' & l = 'A'
        if(r == l + 1 && l == i && str.charAt(l) == 'A' && str.charAt(r) == 'B')
            return false;

        return true;
    }


    private static void permute_BT(String str, String notStr, int l, int r) {
        if(l == r) {
            if(!str.contains(notStr))
                System.out.println(str);
            return;
        }
        for(int i = l; i <= r; i++) {
            // Don't proceed if in-hand string contains 'AB' ->
            if(isSafe(str, l, r, i)) {
                str = swap(str, i, l);
                permute_BT(str, notStr, l + 1, r);
                str = swap(str, i, l);
            }
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
