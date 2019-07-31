package medium;

public class _79_Word_Search {
    public boolean exist(char[][] board, String word) {

        char c = word.charAt(0);
        boolean[][] used = new boolean[board.length][board[0].length];
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    used[i][j] = true;
                    x = i;
                    y = j;
                    if (match(word, 1, board, used, x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean match(String word, int index, char[][] board, boolean[][] used, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        used[x][y] = true;
        if (x + 1 < board.length && board[x + 1][y] == c && !used[x + 1][y]) {
            if (match(word, index + 1, board, used, x + 1, y)) {
                return true;
            }
        }
        if (x - 1 > -1 && board[x - 1][y] == c && !used[x - 1][y]) {
            if (match(word, index + 1, board, used, x - 1, y)) {
                return true;
            }
        }
        if (y + 1 < board[0].length && board[x][y + 1] == c && !used[x][y + 1]) {
            if (match(word, index + 1, board, used, x, y + 1)) {
                return true;
            }
        }
        if (y - 1 > -1 && board[x][y - 1] == c && !used[x][y - 1]) {
            if (match(word, index + 1, board, used, x, y - 1)) {
                return true;
            }
        }
        used[x][y] =false;
        return false;
    }
}
