package amazon;

public class _348DesignTicTacToe {
    class TicTacToe {

        /** Initialize your data structure here. */
        int[][] board;
        int n;

        public TicTacToe(int n) {
            this.n = n;
            board = new int[n][n];
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         * 
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either: 0: No one wins. 1:
         *         Player 1 wins. 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            board[row][col] = player;
            return checkWin(row, col);
        }

        int checkWin(int row, int col) {
            int player = board[row][col];
            boolean win = true;
            for (int i = 0; i < n; i++) {
                if (player != board[i][col]) {
                    win = false;
                }
            }
            if (win) {
                return player;
            }
            win = true;
            for (int i = 0; i < n; i++) {
                if (player != board[row][i]) {
                    win = false;
                }
            }
            if (win) {
                return player;
            }
            if (row == col) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (player != board[i][i]) {
                        win = false;
                    }
                }
                if (win) {
                    return player;
                }
            }
            if (row + col == n - 1) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (player != board[i][n - i - 1]) {
                        win = false;
                    }
                }
                if (win) {
                    return player;
                }
            }
            return 0;
        }
    }
}
