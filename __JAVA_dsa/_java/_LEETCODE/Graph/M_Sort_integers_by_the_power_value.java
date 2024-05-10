package _dsa._java._LEETCODE.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Question: https://leetcode.com/problems/sort-integers-by-the-power-value/submissions/
// Response: Solved

public class M_Sort_integers_by_the_power_value {

    public static void main(String[] args) {
        int lo = 12;
        int hi = 15;
        int k = 2;

        int fir = getKth_FirstSolution(lo, hi, k);
        System.out.println("First SOl: " + fir);

        int sec = getKth_SecondSolution(lo, hi, k);
        System.out.println("Second SOl: " + sec);
    }

    public static int getKth_FirstSolution(int lo, int hi, int k) {
        List<Pair> res = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            int count = 0;
            int num = i;

            while (num != 1) {
                if (num % 2 == 0)
                    num /= 2;
                else
                    num = (3 * num) + 1;
                count++;
            }

            int po = count;
            res.add(new Pair(i, po));
        }

        Collections.sort(res, new SortByPo());
        return res.get(k - 1).val;
    }

    public static int getKth_SecondSolution(int lo, int hi, int k) {
        List<Pair> res = new ArrayList<>();

        int t[] = new int[1001];
        Arrays.fill(t, -1);

        for (int i = lo; i <= hi; i++) {
            int po = 0;
            int num = i;
            if (t[i] == -1) {
                while (num != 1) {
                    if (num % 2 == 0)
                        num /= 2;
                    else
                        num = (3 * num) + 1;
                    t[i] = po++;
                }
            } else {
                po = t[0] - t[i];
                break;
            }

            res.add(new Pair(i, po));
        }

        Collections.sort(res, new SortByPo());
        return res.get(k - 1).val;
    }

    public static class SortByPo implements Comparator<Pair> {

        public int compare(Pair a, Pair b) {
            if (a.po == b.po) {
                return a.val - b.val;
            }

            return a.po - b.po;
        }
    }

    public static class Pair {
        int val;
        int po;

        Pair(int val, int po) {
            this.po = po;
            this.val = val;
        }
    }

}
