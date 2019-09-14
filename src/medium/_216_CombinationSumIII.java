package medium;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {
    int[] sum = { 0, 1, 3, 6, 10, 15, 21, 28, 36, 45 };

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        recursion(result, k, n, 1, temp);
        return result;
    }

    private void recursion(List<List<Integer>> result, int k, int n, int start, List<Integer> temp) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (n <= 0 || k <= 0) {
            return;
        }
        int i = 0;
        while (sum[k] + (start + i - 1) * k <= n && start + i < 10) {
            temp.add(start + i);
            recursion(result, k - 1, n - start - i, start + i + 1, temp);
            temp.remove(temp.size() - 1);
            i++;
        }
    }
}
