package blind75.matrix;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{ new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "SEE";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        return false;
    }

    public boolean backtracking(char[][] board, int p1, int p2, String word, int cur) {
        return true;
    }

}
