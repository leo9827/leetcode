package neetcode150.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            if(K == points.length) return points;

            PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
                }
            });

            for(int[] point: points) {
                pq.add(point);
                if(pq.size() > K) pq.poll();
            }
            return pq.toArray(new int[0][0]);
        }
    }
}
