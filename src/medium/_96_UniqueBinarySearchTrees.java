package medium;

public class _96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[][] DPMatrix = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            DPMatrix[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {

                for (int j = i; j <= i + len - 1; j++) {
                    int left = DPMatrix[i][j - 1];
                    int right = DPMatrix[j + 1][i + len - 1];
                    if (left * right == 0) {
                        DPMatrix[i][i + len - 1] += ((left + right) == 0 ? 1 : (left + right));
                    } else {
                        DPMatrix[i][i + len - 1] += left*right;
                    }
                }
            }
        }

        return DPMatrix[1][n];
    }

}
