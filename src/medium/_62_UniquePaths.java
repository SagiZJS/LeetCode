package medium;

public class _62_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i <= m + n - 2; i++) {
            for (int j = 0; j <= i && j < m; j++) {
                if (i - j >= n) {
                    continue;
                }
                if (j > 0) {
                    res[j][i - j] += res[j - 1][i - j];
                }
                if (j < i) {
                    res[j][i - j] += res[j][i - j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        _62_UniquePaths s = new _62_UniquePaths();
        s.uniquePaths(3, 2);
    }
}
