package blind75.array;

public class ContainerWithMostWater {

    public int maxArea1(int[] height) {
        int max = 0;
        int head = 0, tail = height.length - 1;
        while (head < tail) {
            int h = Math.min(height[head], height[tail]); // 计算高度
            max = Math.max(max, (tail - head) * h); // 计算面积 = 底*高
            if (height[head] > height[tail]) { // 将比较矮的一端向中间移动
                tail--;
            } else {
                head++;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1 ;
        int maxLeft, maxRight;
        int area = 0, maxArea = 0 ;

        while (i < j) {
            maxLeft = height[i] ;
            maxRight = height[j] ;

            if (maxRight > maxLeft) area = maxLeft * (j-i) ;
            else area = maxRight * (j-i) ;

            maxArea = Math.max(maxArea, area);

            if (maxRight > maxLeft) {
                while (i < j && height[i] <= maxLeft) { // 优化判断
                    i++ ;
                }
            } else {
                while (i < j && height[j] <= maxRight) {
                    j-- ;
                }
            }
        }
        return maxArea ;
    }
}
