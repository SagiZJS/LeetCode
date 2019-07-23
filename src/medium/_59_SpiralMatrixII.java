package medium;


public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        return spiralOrder(new int[n][n]);
    }

    public int[][] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = 1;
        for (; i < m / 2 && i < n / 2; i++) {
            count = oneRound(i, matrix, count);
        }
        if (m <= n && m % 2 == 1) {
            int index = 0;

            while (i + index < n - i) {
                matrix[i][i + index++] = count++;
            }
        }
        if (n < m && n % 2 == 1) {
            int index = 0;
            while (i + index < m - i) {
                matrix[i + index++][i] = count++;
            }
        }
        return matrix;
    }

    public int oneRound(int round, int[][] matrix, int count) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = round;
        int y = round;
        int xd = 0;
        int yd = 1;

        while (true) {
            matrix[x][y] = count++;
            if (x == round && y == n - 1 - round) {
                xd = 1;
                yd = 0;
            }
            if (x == m - 1 - round && y == n - 1 - round) {
                xd = 0;
                yd = -1;
            }
            if (x == m - 1 - round && y == round) {
                xd = -1;
                yd = 0;
            }
            if (x == round + 1 && y == round) {
                break;
            }
            x += xd;
            y += yd;
        }
        return count;
    }
}
