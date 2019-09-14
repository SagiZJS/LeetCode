package medium;

public class _221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] DPMatix = new int[matrix.length][matrix[0].length];
        int max = 0;
        if (matrix[0][0] == '1') {
            DPMatix[0][0] = 1;
            max = 1;
        } else {
            DPMatix[0][0] = 0;
        }
        for (int s = 1; s < matrix.length + matrix[0].length; s++) {
            for (int i = 0; i <= s; i++) {
                int j = s - i;
                if (j >= matrix[0].length || i >= matrix.length) {
                    continue;
                }
                if (matrix[i][j] == '0')
                    continue;
                if (i == 0) {
                    DPMatix[i][j] = 1;
                } else if (j == 0) {
                    DPMatix[i][j] = 1;
                } else {
                    DPMatix[i][j] = Math.min(DPMatix[i - 1][j - 1], DPMatix[i - 1][j]);
                    DPMatix[i][j] = Math.min(DPMatix[i][j], DPMatix[i][j - 1]);
                    DPMatix[i][j]++;
                }
                if (max < DPMatix[i][j]) {
                    max = DPMatix[i][j];
                }

            }
        }
        return max * max;
    }
    public static void main(String[] args) {
        
        _221_MaximalSquare
        s = new _221_MaximalSquare();
        char[][] matrix = new char[][] {{'0','1'}
//                {{'1','0','1','0','0'},
//            {'1','0','1','1','1'},
//            {'1','1','1','1','1'},
//            {'1','0','0','1','0'},
//            {'1','0','1','0','0'}
            };
            s.maximalSquare(matrix);
    }
}
