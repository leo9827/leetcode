package neetcode150.stack;

/**
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 * <p>
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i
 * 辆车的速度(单位是英里/小时)。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度
 * 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * <p>
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * <p>
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * 返回到达目的地的 车队数量 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * <p>
 * 示例 2:
 * 输入: target = 10, position = [3], speed = [3]
 * 输出: 1
 * 解释: 只有一辆车，因此只有一个车队。
 * <p>
 * 示例 3:
 * 输入: target = 100, position = [0,2,4], speed = [4,2,1]
 * 输出: 1
 * 解释:
 * 以0(速度4)和2(速度2)出发的车辆组成车队，在4点相遇。舰队以2的速度前进。
 * 然后，车队(速度2)和以4(速度1)出发的汽车组成一个车队，在6点相遇。舰队以1的速度前进，直到到达目标。
 * <p>
 * 提示：
 * n == position.length == speed.length
 * 1 <= n <= 10^5
 * 0 < target <= 10^6
 * 0 <= position[i] < target
 * position 中每个值都 不同
 * 0 < speed[i] <= 10^6
 */

public class CarFleet {

    /**
     * 我的思路1:
     * 每次行进一步（1个speed），然后看车辆是否到达同样的位置，
     * 然后合并相同位置的车辆为一个车队，两个车合并为同一个车队时，会以慢的那个车的速度继续行驶
     * 直到所有的车到达终点
     * <p>
     * 2: 思路2，不需要步长和是否到终点，只需要看相邻的两个车是否合并（车辆1到达时间是否小于车辆2）
     * target = 12, position = [10,8, 0, 5, 3], speed = [2,4,1,1,3]
     * costtime= [1, 1,12, 7, 3]  1,1, 12, 3,7
     * arrivetime= [12,0,0,3,0,7,0,0,0,1,0,1,0,0]
     * 比你后出发，然后耗时跟你一样，或者是比你小，那么肯定能追上你，如果比你位置靠后耗时还比你长，那肯定追不上你
     * 这里arrivetime 数组是所有车辆按照自己的起始位置从小到达排序的位置排列,相当于按照postion起始位置从小到大排序过
     * 这样从后往前看的时候,后出发先到的车就可以和前车合并为一个车队,并以前车到达时间为准(合并后以车队最慢车速行驶(即最大到达时间), 如果后出发还追不上(耗时大于先出发的车),那么这个车就追不上前车了,单独作为一个车队.
     */
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length < 2) return position.length;

        float[] arrivedTime = new float[target + 1];
        for (int i = 0; i < position.length; i++) {
            arrivedTime[position[i]] = (float) (target - position[i]) / speed[i];
        }

        int fleets = 0;
        float max = 0;
        for (int i = target; i >= 0; i--) {
            // 后出发先到的车就可以和前车合并为一个车队,并以前车到达时间为准(合并后以车队最慢车速行驶(即最大到达时间),
            // 如果后出发还追不上(耗时大于先出发的车),那么这个车就追不上前车了,单独作为一个车队.
            if (arrivedTime[i] > max) {
                fleets++;
                max = arrivedTime[i];
            }
        }

        return fleets;
    }

    public int carFleet2(int target, int[] position, int[] speed) {
        
        float[] timecosts = new float[target+1]; // cal every position arrived target time costs. so need target length arr
        for (int i=0; i<position.length; i++) {
            int pos = position[i];
            timecosts[pos] = (float)(target-pos) / speed[i];
        }
    
        int fleets = 0;
        float curmaxcost = 0;
        for (int i=target; i>=0; i--) {  // from end to start
            if (timecosts[i] > curmaxcost) { // if costtime > lastMax(position after cur,but time cost less cur), then, add new fleet
                fleets++;
                curmaxcost = timecosts[i];
            }
        }

        return fleets;
    }
}
