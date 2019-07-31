package medium;

public class _64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        return uniquePaths(grid.length, grid[0].length, grid);
    }

    public int uniquePaths(int m, int n, int[][] grid) {
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= m + n - 2; i++) {
            for (int j = 0; j <= i && j < m; j++) {
                if (i - j >= n) {
                    continue;
                }
                min = Integer.MAX_VALUE;
                if (j > 0) {
                    min = res[j - 1][i - j];
                }
                if (j < i) {
                    min = min <= res[j][i - j - 1] ? min : res[j][i - j - 1] ;
                }
                res[j][i -j] += grid[j][i-j] + min;
            }
        }
        return res[m - 1][n - 1];
    }
}
