package blind75;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestKElement {

    public static void main(String[] args) {
        SmallestKElement s = new SmallestKElement();
        System.out.println(s.getLatestNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
    // 最小的k个数
    public ArrayList<Integer> getLatestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i1,i2) -> i2-i1);

        for (int num : nums) {
            if (heap.isEmpty() || heap.size() < k || heap.peek() > num) {
                heap.add(num);
            }
            if (heap.size() > k) heap.poll();
        }
        ArrayList<Integer> ret = new ArrayList<>(k);
        ret.addAll(heap);
        return ret;
    }

}
