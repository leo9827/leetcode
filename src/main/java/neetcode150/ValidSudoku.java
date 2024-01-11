package neetcode150;

// https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * Example1
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * <p>
 * Example2
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 思路1: 每一行进行重复数字检查，每一列进行重复数字检查，每个九宫格进行重复数字检查
        for (int i=0; i < 9; i++) {
            if (rowHasDup(i, board)) { return false;}
            if (colHasDup(i, board)) { return false;}
            if (ninHasDup(i, board)) { return false;}
        }
        return true;
    }

    private boolean rowHasDup(int rowIdx, char[][] board) {
        char[] row = board[rowIdx];
        Set<Character> se = new HashSet<>();
        for (char c:row) {
            if (c != '.' &&se.contains(c)) {
                return true;
            }
            se.add(c);
        }
        return false;
    }

    private boolean colHasDup(int colIdx, char[][] board) {
        Set<Character> se = new HashSet<>();
        for (int i = 0; i<9; i++) {
            char c = board[i][colIdx];
            if (c != '.' &&se.contains(c)) {
                return true;
            }
            se.add(c);
        }
        return false;
    }

    private boolean ninHasDup(int ninIdx, char[][] board) {
        Set<Character> se = new HashSet<>();
        int row = 3*(ninIdx/3);
        int col = 3*(ninIdx%3);
        for (int i = 0; i< 3; i++) {
            for (int j = 0; j<3; j++) {
                char c = board[row+i][col+j];
                if (c != '.' && se.contains(c)) {
                    return true;
                }
                se.add(c);
            }
        }
        return false;
    }

    public boolean isValidSudoku2(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

}











