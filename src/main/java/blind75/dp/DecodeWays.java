package blind75.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays ways = new DecodeWays();
        System.out.println(ways.numDecodings("12")); //2
        System.out.println(ways.numDecodings("226"));//3
        System.out.println(ways.numDecodings("06")); //0
        System.out.println(ways.numDecodings("11106")); //2 :1 1 10 6  11 10 6
        System.out.println(ways.numDecodings("2611055971756562"));
        System.out.println(ways.numDecodings("55971756562"));
        System.out.println(ways.numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println("123106");
        System.out.println(ways.numDecodingsTabulation("123106"));
    }

    public int numDecodings(String s) {
        return numDecodings(s, new HashMap<>(s.length()));
    }
    public int numDecodings(String s, Map<String, Integer> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (s.startsWith("0")) {
            memo.put(s, 0);
            return 0;
        }
        /*
        只能是 1～26
        case1: 11106
        case2: 06
         */
        // 左边合法的情况下计算右边
        if (s.length() == 1) {
            memo.put(s, 1);
            return 1;
        }

        if (s.length() == 2 && !s.startsWith("0")) {
            int val = Integer.parseInt(s);
            if (val>1&&val<27) {
                int ret =  1+numDecodings(s.substring(1), memo);
                memo.put(s, ret);
                return ret;
            } else {
                int ret= numDecodings(s.substring(1), memo);
                memo.put(s, ret);
                return ret;
            }
        }

        int count=0;
        // length > 3
        for (int i = 1; i < 3; i++) {
            // left is valid
            int val = Integer.parseInt(s.substring(0, i));
            if (val>0&&val<27) {
                count += numDecodings(s.substring(i), memo);
            }
        }

        memo.put(s, count);
        return count;
    }

    public int numDecodingsTabulation(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] table = new int[s.length() + 1];
        table[0] = 1; // 种子
        table[1] = s.charAt(0) == '0' ? 0 : 1; // 种子1
        System.out.println(Arrays.toString(table));
        System.out.println();
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                table[i] += table[i-1];
            }
            System.out.println(Arrays.toString(table));
            if (second >= 10 && second <= 26) {
                table[i] += table[i-2];
            }
            System.out.println(Arrays.toString(table));
        }
        return table[s.length()];
    }
}
