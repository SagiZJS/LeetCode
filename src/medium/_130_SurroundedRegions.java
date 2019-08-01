package medium;

public class _130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] notSurroundeds = new boolean[board.length][board[0].length];

        for (int i = 0; i < notSurroundeds[0].length; i++) {
            if (board[0][i] == 'O' && notSurroundeds[0][i] == false) {
                mark(board, notSurroundeds, 0, i);
            }
            if (board[notSurroundeds.length - 1][i] == 'O' && notSurroundeds[notSurroundeds.length - 1][i] == false) {
                mark(board, notSurroundeds, notSurroundeds.length - 1, i);
            }
        }
        for (int i = 1; i < notSurroundeds.length-1; i++) {
            if (board[i][0] == 'O' && notSurroundeds[i][0] == false) {
                mark(board, notSurroundeds, i, 0);
            }
            if (board[i][notSurroundeds[0].length -1] == 'O' && notSurroundeds[i][notSurroundeds[0].length -1] == false) {
                mark(board, notSurroundeds, i, notSurroundeds[0].length -1);
            }
            
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !notSurroundeds[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void mark(char[][] board, boolean[][] notSurroundeds, int i, int j) {
        notSurroundeds[i][j] =true;
        if (i > 0 && board[i - 1][j] == 'O' && !notSurroundeds[i-1][j]) {
            mark(board, notSurroundeds, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O' && !notSurroundeds[i+1][j]) {
            mark(board, notSurroundeds, i + 1, j);
        }
        if (j > 0 && board[i][j-1] == 'O' && !notSurroundeds[i][j-1]) {
            mark(board, notSurroundeds, i, j-1);
        }
        if (j < board[0].length - 1 && board[i ][j+1] == 'O' && !notSurroundeds[i][j+1]) {
            mark(board, notSurroundeds, i , j+1);
        }
    }
public static void main(String[] args) {
}

}
