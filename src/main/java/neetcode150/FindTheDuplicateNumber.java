package neetcode150;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * Follow up:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 当两个指针首次相遇时，它们相遇的位置并不一定是重复元素本身。\
        // 这是因为p2每次移动两个位置，所以它的速度更快，
        // 可能会在环状结构中多绕几圈才与p1相遇。因此，当两个指针相遇时，我们不能确定相遇位置就是重复元素的位置。

        // 我们重置p1的值为0，然后将两个指针以相同的步长（每次移动一个位置）继续遍历数组，
        // 直到它们再次相遇。此时，它们相遇的位置就是重复元素的位置
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int[] case1 = new int[]{1, 3, 4, 2, 2};
        int ans1 = 2;
        System.out.println(f.findDuplicate(case1) == ans1);

        int[] case2 = new int[]{3, 1, 3, 4, 2};
        int ans2 = 3;
        System.out.println(f.findDuplicate(case2) == ans2);
    }
}
