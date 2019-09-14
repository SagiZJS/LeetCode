package medium;

public class _200_NumberofIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result ++ ;
                    findAndFlipAllAlongTheWay(grid, i, j);
                }
            }
        }
        return result;
    }
    
    public void findAndFlipAllAlongTheWay(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length) return;
        if (j < 0 || j > grid[0].length) return;
        if (grid[i][j] == '0') return; 
        grid[i][j] = '0';
        findAndFlipAllAlongTheWay(grid, i + 1, j);
        findAndFlipAllAlongTheWay(grid, i - 1, j);
        findAndFlipAllAlongTheWay(grid, i, j+1);
        findAndFlipAllAlongTheWay(grid, i, j-1);
    }
}

