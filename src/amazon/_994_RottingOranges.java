package amazon;


public class _994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] dis = new int[grid.length][grid[0].length];
        int[][] queue = new int[grid.length * grid[0].length][];
        int h = 0;
        int t = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dis[i][j] = -1;
                if (grid[i][j] == 2) {
                    queue[t++] = step(i, j, 0);
                    dis[i][j] = 0;
                }
            }
        }
        int step = 0;
        while (h < t) {
            int[] temp = queue[h++];
            int i = temp[0];
            int j = temp[1];
            step = temp[2];
            if (i > 0 && dis[i - 1][j] == -1 && grid[i - 1][j] == 1) {
                dis[i - 1][j] = step + 1;
                grid[i - 1][j] = 2;
                queue[t++] = step(i - 1, j, step + 1);
            }
            if (j > 0 && dis[i][j - 1] == -1 && grid[i][j - 1] == 1) {
                dis[i][j - 1] = step + 1;
                grid[i][j - 1] = 2;
                queue[t++] = step(i, j - 1, step + 1);
            }
            if (i < grid.length - 1 && dis[i + 1][j] == -1 && grid[i + 1][j] == 1) {
                dis[i + 1][j] = step + 1;
                grid[i + 1][j] = 2;
                queue[t++] = step(i + 1, j, step + 1);
            }
            if (j < grid[0].length - 1 && dis[i][j + 1] == -1 && grid[i][j + 1] == 1) {
                dis[i][j + 1] = step + 1;
                grid[i][j + 1] = 2;
                queue[t++] = step(i, j + 1, step + 1);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return step;

    }

    public int[] step(int i, int j, int step) {
        return new int[] { i, j, step };
    }

}
