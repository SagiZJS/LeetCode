package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tempSum = new ArrayList<>();
//
//        Arrays.sort(candidates);
//
//        comSumRecursion(res, target, -1, 0, candidates, tempSum, -2);
//        return res;
//    }
//
//    public void comSumRecursion(List<List<Integer>> res, int target, int index, int sum, int[] candidates,
//            List<Integer> tempSum, int lastadd) {
//        if (sum > target) {
//            return;
//        }
//        if (sum == target) {
//            res.add(new ArrayList<>(tempSum));
//        }
//
//        for (index++; index < candidates.length; index++) {
//            if (lastadd+1 >= index && candidates[index] == candidates[index - 1]) {
//                continue;
//            }
//            tempSum.add(candidates[index]);
//            comSumRecursion(res, target, index, sum + candidates[index], candidates, tempSum, index);
//            tempSum.remove(tempSum.size() - 1);
//        }
//    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        int n = candidates.length;
        Arrays.sort(candidates);
        boolean[] visited = new boolean[n];
        helper(0, new ArrayList<>(), candidates, target, res, visited);
        return res;
    }
    void helper(int index, List<Integer> list, int[] candidates, int target, List<List<Integer>> res, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && !visited[i - 1] && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            visited[i] = true;
            list.add(candidates[i]);
            helper(i + 1, list, candidates, target - candidates[i], res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        _40_CombinationSumII s = new _40_CombinationSumII();
        int[] candidates = new int[] { 1 };
        int target = 1;
        List<List<Integer>> res = s.combinationSum2(candidates, target);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
