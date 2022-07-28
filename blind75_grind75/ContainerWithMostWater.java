package grind75;

public class ContainerWithMostWater {

    public int maxArea1(int[] height) {
        int max = 0;
        int head = 0, tail = height.length - 1;
        while (head < tail) {
            int h = Math.min(height[head], height[tail]);
            max = Math.max(max, (tail - head) * h);
            if (height[head] > height[tail]) {
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
                while (i < j && height[i] <= maxLeft) {
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
