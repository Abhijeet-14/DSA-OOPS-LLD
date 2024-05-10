package _dsa._15_12_21_practice.MCM_DP;

public class C6_Egg_Dropping {
    // Question:
    // We have n-no of floors, e-eggs,
    // we need find the max floor from which if egg will drop, then it will break
    // with min no of attempts.
    public static void main(String[] args) {
        int floor = 20;
        int egg = 3;

        int rec = solve(egg, floor);
        System.out.println(rec);
    }

    private static int solve(int egg, int floor) {
        // if floor is 1 or 0 -> no of attempts is 0/1.
        if(floor == 0 || floor == 1)
            return floor;

        // if egg is 1, go 0->n, 1 by 1.
        if(egg == 1)
            return floor;

        int mn = Integer.MAX_VALUE;
        for(int k = 1; k <= floor; k++) {
            // break(possible location (0, k-1) , non-break(possible location (n-k)->(n))
            int temp = 1 + Math.max(solve(egg - 1, k - 1), solve(egg, floor - k));
            // need to take max floor value

            mn = Math.min(mn, temp);
            // with minimum no of attempts.
        }

        return mn;
    }
}
