package blind75.backtracking;

/**
 * 给定一个二维字符网格board和一个字符串单词word,判定word是否存在于网格中,规则是可以通过相邻单元格上下左右进行搜索。
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{ new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "SEE";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        return backtracking(board, 0, 0, word, 0);
    }

    public boolean backtracking(char[][] board, int p1, int p2, String word, int cur) {
        return true;
    }

}
