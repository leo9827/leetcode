package grind75;

import java.util.Arrays;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '0', '0'},
                new char[]{'1', '1', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '0'},
                new char[]{'0', '0', '0', '0', '1'}
        };
        System.out.println(n.numIslands(grid));
        char[][] grid2 = new char[][]{
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','1','1','0'},
                new char[]{'0','0','0','0','0'}
        };
        System.out.println(n.numIslands(grid2));
        char[][] grid3 = new char[][]{
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}
        };
        System.out.println(n.numIslands(grid3));
    }

    public int numIslands(char[][] grid) {
        /*
[
  ['1','1','0','1','0'],
  ['1','1','0','1','0'],
  ['1','1','1','1','0'],
  ['0','0','0','0','0']
]
=>1
Input: grid = [
  ['1','1','1','0','0'],
  ['1','1','1','0','0'],
  ['0','0','0','1','0'],
  ['0','0','0','0','1']
]
Output: 3

[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]

[
[-, -, 0, 0, 0],
[-, -, 0, 0, 0],
[0, 0, 1, 0, 0],
[0, 0, 0, 1, 1]
]
[
[-, -, 0, 0, 0],
[-, -, 0, 0, 0],
[0, 0, -, 0, 0],
[0, 0, 0, 1, 1]
]
[
[-, -, 0, 0, 0],
[-, -, 0, 0, 0],
[0, 0, -, 0, 0],
[0, 0, 0, -, 1]
]
[
[-, -, 0, 0, 0],
[-, -, 0, 0, 0],
[0, 0, -, 0, 0],
[0, 0, 0, -, 1]
]
=> 3
         */

        // 重要的一点: 所有的1如果有有相连，那么视为同一个整体,1和1之间出现了0才会计为2个不同的岛屿
        // 标记法：走过的路标记为不同的符号
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
//                    System.out.println(i + " " + j);
                    mark(grid, i, j);
//                    System.out.println(Arrays.deepToString(grid));
                    count++;
                }
            }
        }

        return count;
    }

    public void mark(char[][] grid, int i, int j) {
        if (i<0 || i>= grid.length|| j<0 || j>= grid[i].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '-';
            mark(grid, i-1,j);
            mark(grid, i+1,j);
            mark(grid, i,j-1);
            mark(grid, i,j+1);
        }
    }

}
