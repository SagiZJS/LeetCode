package medium;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            recursion(n, k, result, temp, i);
        }
        return result;
    }

    public void recursion(int n, int k, List<List<Integer>> result, List<Integer> temp, int num) {
        temp.add(num);
        if (k == 1) {
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        for (int i = num + 1; i <= n; i++) {
            recursion(n, k - 1, result, temp, i);
        }
        temp.remove(temp.size() - 1);
    }
}
