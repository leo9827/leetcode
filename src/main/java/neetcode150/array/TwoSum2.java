package neetcode150.array;
import java.util.Map;
import java.util.HashMap;

public class TwoSum2 {
    public int[] twoSum2(int[] numbers, int target) {
        int cur = 0;
        while (cur < numbers.length - 1) {
            int left = cur, right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (numbers[left] + numbers[right] > target) {
                    right--;
                }
                if (numbers[left] + numbers[right] < target) {
                    cur++;
                    break;
                }
            }
        }
        return null;
    }
    public int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left <= right){
            int sum = numbers[left] + numbers[right];
            if(sum < target)
                left++;
            else if (sum > target)
                right --;
            else
                return new int[]{left+1,right+1};
        }

        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            table.put(numbers[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (table.containsKey(target - entry.getKey())) {
                return new int[]{entry.getValue() + 1, table.get(target - entry.getKey()) + 1};
            }
        }
        return null;
    }

}
