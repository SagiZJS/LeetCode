package amazon;

public class _1000_MinimumCosttoMergeStones {
    public int mergeStones(int[] stones, int K) {
        if ((stones.length - 1) % (K - 1) != 0)
            return -1;
        int[] sum = new int[stones.length + 1];
        int[][] dp = new int[stones.length][stones.length];
        for (int i = 1; i < stones.length + 1; i++) {
            sum[i] = stones[i - 1] + sum[i - 1];
        }
        for (int r = 1; r < stones.length; r++) {
            for (int l = r - K + 1; l >= 0; l--) {
                int min = Integer.MAX_VALUE;
                for (int n = 1; l + n < r; n += K - 1) {
                    int mid = r - n + 1;
                    int left = dp[l][mid-1];
                    int right = dp[mid][r];
                    if (left + right < min) {
                        min = left + right;
                    }
                    dp[l][r] = min;
                }
                if ((r - l) % (K - 1) == 0) {
                    dp[l][r] += sum[r + 1] - sum[l];
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        _1000_MinimumCosttoMergeStones s = new _1000_MinimumCosttoMergeStones();
        int[] stones = new int[] { 3, 5, 1, 2, 6 };
        s.mergeStones(stones, 2);
    }
}
