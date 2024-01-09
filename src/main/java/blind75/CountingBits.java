package blind75;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits bits = new CountingBits();
        System.out.println(Arrays.toString(bits.countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(bits.countBits(5))); // [0,1,1,2,1,2]
    }
    public int[] countBits(int n) {
        int[] ret = new int[n+1];

        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i >> 1] + (i & 1);
        }
        return ret;
    }

}
