package neetcode150.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ， <p>
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。 <p>
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。 <p>
 * <p>
 * 示例 1: <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73] <p>
 * 输出: [1,1,4,2,1,1,0,0] <p>
 * <p>
 * 示例 2: <p>
 * 输入: temperatures = [30,40,50,60] <p>
 * 输出: [1,1,1,0] <p>
 * <p>
 * 示例 3: <p>
 * 输入: temperatures = [30,60,90] <p>
 * 输出: [1,1,0] <p>
 * <p>
 * 提示：
 * 1 <= temperatures.length <= 105 <p>
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] case1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] expect1 = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        System.out.println(Arrays.equals(d.dailyTemperatures(case1), expect1));
        int[] case2 = new int[]{30, 40, 50, 60};
        int[] expect2 = new int[]{1, 1, 1, 0};
        System.out.println(Arrays.equals(d.dailyTemperatures(case2), expect2));
    }

    /**
     * example:  [73,74,75,71,69,78]
     * solution: ans: [0,0,0,0,0,0], l: []
     * [0(73)]
     * [0,0,0,0,0,0]
     * <p>
     * [1(74)]
     * [1,0,0,0,0,0] (ans[0]=1(74)-0(73))
     * <p>
     * [2(75)]
     * [1,1,0,0,0,0] (ans[1]=2(75)-1(74))
     * <p>
     * [2(75),3(71)]
     * [1,1,0,0,0,0]
     * <p>
     * [2(75),3(71),4(69)]
     * [1,1,0,0,0,0]
     * <p>
     * [2(75),3(71),4(69)] -> [5(78)]
     * [1,1,0,0,0,0] -> [1,1,3,2,1,0] (ans[4]=5-4, ans[3]=5-3, ans[2]=5-2)
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (!l.isEmpty() && temperatures[i] > temperatures[l.getLast()]) {
                while (!l.isEmpty() && temperatures[i] > temperatures[l.getLast()]) {
                    int prevIdx = l.getLast(); // eq stack.pop()
                    l.removeLast();
                    ans[prevIdx] = i - prevIdx; // cal distance
                }
            }
            l.addLast(i);
        }
        return ans;
    }
    
    public int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        return ans;

    }
}