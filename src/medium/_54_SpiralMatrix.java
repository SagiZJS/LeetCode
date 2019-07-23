package medium;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        for (; i < m / 2 && i < n / 2; i++) {
            oneRound(i, matrix, result);
        }
        if (m <= n && m % 2 == 1) {
            int index = 0;
            
            while (i+index < n - i) {
                result.add(matrix[i][i + index++]);
            }
        }
        if (n < m && n % 2 == 1) {
            int index = 0;
            while (i+index < m - i) {
                result.add(matrix[i+ index++][i]);
            }
        }
        return result;
    }

    public void oneRound(int round, int[][] matrix, List<Integer> result) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = round;
        int y = round;
        int xd = 0;
        int yd = 1;

        while (true) {
            result.add(matrix[x][y]);
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
    }

}
