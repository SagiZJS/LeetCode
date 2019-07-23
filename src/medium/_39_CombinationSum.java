package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _39_CombinationSum {

    class Combination {
        public int[] nums;
        public Combination next;

        public Combination(int[] nums) {
            this.nums = nums;
        }

        public Combination(int val, int[] nums) {
            int[] temp = new int[nums.length + 1];
            temp[0] = val;
            System.arraycopy(nums, 0, temp, 1, nums.length);
            this.nums = temp;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int min = candidates[0];
        for (int i : candidates) {
            if (i < min) {
                min = i;
            }
        }
        Combination[][] combinations = new Combination[target + 1][target + 1];
        Combination combination = null;
        int count = 0;
        for (int i : candidates) {
            if (i <= target) {
                combinations[count][i] = new Combination(new int[] { i });
            }
        }
        combination = combinations[count][target];
        addRes(res, combination, count, target);
        count++;
        int times = 2;
        while (times * min <= target) {
            for (int i = 0; i < target + 1; i++) {
                if (combinations[count - 1][i] != null) {
                    for (int num : candidates) {
                        if (num + i > target) {
                            continue;
                        }
                        Combination temp = combinations[count - 1][i];
                        while (temp != null) {
                            combination = new Combination(num, temp.nums);
                            combination.next = combinations[count][num + i];
                            combinations[count][num + i] = combination;
                            temp = temp.next;
                        }
                    }
                }
            }
            combination = combinations[count][target];
            addRes(res, combination, count, target);
            times++;
            count++;
        }
        return res;
    }

    public void addRes(List<List<Integer>> res, Combination combination, int count, int target) {
        List<Integer> solution = new ArrayList<>();
        while (combination != null) {
            for (int num : combination.nums) {
                solution.add(num);
            }
            solution.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (!res.contains(solution)) {
                res.add(solution);
            }
            solution = new ArrayList<>();
            combination = combination.next;
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum s = new _39_CombinationSum();
        int[] candidates = new int[] { 7, 2, 3 };
        int target = 18;
        List<List<Integer>> res = s.combinationSum(candidates, target);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
