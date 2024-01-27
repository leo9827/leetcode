package neetcode150.heap;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75">2336. Smallest Number in Infinite Set</a>
 * Medium
 */
public class SmallestNumberInInfiniteSet {
    public static PriorityQueue<Integer> pq;
    int i = 1;

    public SmallestNumberInInfiniteSet() {
        pq = new PriorityQueue<Integer>();
    }

    public int popSmallest() {
        if (pq.isEmpty()) return i++;
        return pq.poll();
    }

    public void addBack(int num) {
        if (num < i && !pq.contains(num)) pq.add(num);
    }
}
