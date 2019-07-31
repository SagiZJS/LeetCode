package medium;

public class _73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[] x = new boolean[matrix.length];
        boolean[] y = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = true;
                    y[j] = true;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0;j < y.length; j++) {
            if (y[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
