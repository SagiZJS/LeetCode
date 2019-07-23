package medium;

public class _36_ValidSudoku {
    int[] hashtable = null;

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validateColumn(board, i)) {
                return false;
            }
            if (!validateRow(board, i)) {
                return false;
            }
            if (!validateBlock(board, i/3, i%3)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRow(char[][] board, int i) {
        hashtable = new int[10];
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                if (hashtable[board[i][j] - '0'] == 1) {
                    return false;
                } else {
                    hashtable[board[i][j] - '0']++;
                }
            }
        }
        return true;
    }

    private boolean validateColumn(char[][] board, int j) {
        hashtable = new int[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][j] != '.') {
                if (hashtable[board[i][j] - '0'] == 1) {
                    return false;
                } else {
                    hashtable[board[i][j] - '0']++;
                }
            }
        }
        return true;
    }

    private boolean validateBlock(char[][] board, int i, int j) {
        hashtable = new int[10];
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (board[3*i + a][3*j + b] != '.') {
                    if (hashtable[board[3*i + a][3*j + b] - '0'] == 1) {
                        return false;
                    } else {
                        hashtable[board[3*i + a][3*j + b] - '0']++;
                    }
                }
            }
        }
        return true;
    }
}
