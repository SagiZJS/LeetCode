package medium;

public class _63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }

    public int uniquePaths(int m, int n, int[][] obstacleGrid) {

        int[][] res = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        res[0][0] = 1;
        for (int i = 1; i <= m + n - 2; i++) {
            for (int j = 0; j <= i && j < m; j++) {
                if (i - j >= n || obstacleGrid[j][i - j] == 1) {
                    continue;
                }
                if (j > 0 && obstacleGrid[j - 1][i - j] == 0) {

                    res[j][i - j] += res[j - 1][i - j];
                }
                if (j < i && obstacleGrid[j][i - j - 1] == 0) {
                    res[j][i - j] += res[j][i - j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}
