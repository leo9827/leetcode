package neetcode150.dp;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">70. Climbing Stairs</a>
 * Easy  <p>
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
//        return climbStairs(n, new Hashtable<>());
        return climbStairsTabulation(n);
    }

    public int climbStairs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return 1;

        memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        return memo.get(n);
    }

    public int climbStairsTabulation(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (i + 1 <= n) table[i + 1] += table[i];
            if (i + 2 <= n) table[i + 2] += table[i];
        }
        return table[n];
    }


    public static void main(String[] args) {
        System.out.println(new blind75.dp.ClimbingStairs().climbStairs(2)); // 2
        System.out.println(new blind75.dp.ClimbingStairs().climbStairs(3)); // 3
    }
}
