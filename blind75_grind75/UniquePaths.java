package grind75;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 7));//28
        System.out.println(u.uniquePaths(3, 2));//3
        System.out.println(u.uniquePaths(18, 18));//
    }
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m+1][n+1];

        table[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int cur = table[i][j];
                if(j+1<=n) table[i][j+1] += cur;
                if(i+1<=m) table[i+1][j] += cur;
            }
        }
        return table[m][n];
    }
    public int uniquePaths1(int m, int n) {
        return uniquePaths(m,n,new HashMap<>());
    }
    public int uniquePaths(int m, int n, Map<String,Integer> memo) {
        String key = m+","+n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        int ret = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        memo.put(key, ret);
        return memo.get(key);
    }
}
