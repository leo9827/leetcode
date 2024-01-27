package neetcode150.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/?envType=study-plan-v2&envId=leetcode-75">2542. Maximum Subsequence Score</a>
 * <p>
 * Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
 * Output: 12
 */
public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] ess = new int[len][2];
        for (int i = 0; i < len; i++) {
            ess[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long res = 0, sum = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sum = (sum + es[1]);
            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sum * es[0]));
        }
        return res;
    }

    static class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int[][] aug = new int[n][2];
            for (int i = 0; i < n; ++i) {
                aug[i][0] = nums1[i];
                aug[i][1] = nums2[i];
            }
            Arrays.sort(aug, new Comparator<int[]>() {
                public int compare(int[] lhs, int[] rhs) {
                    return -Integer.compare(lhs[1], rhs[1]);
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>(k);
            long ans = 0, total = 0;
            for (int i = 0; i < aug.length; ++i) {
                total += aug[i][0];
                pq.add(aug[i][0]);
                if (i >= k) total -= pq.poll();
                if (i >= k - 1) ans = Math.max(ans, total * aug[i][1]);
            }
            return ans;
        }
    }
}
