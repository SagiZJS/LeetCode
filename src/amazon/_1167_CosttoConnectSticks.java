package amazon;

import java.util.Arrays;

//import java.util.Arrays;
//import java.util.PriorityQueue;

public class _1167_CosttoConnectSticks {
    public int connectSticks(int[] sticks) {
        Arrays.sort(sticks);
        int sum = 0;
        int[] que = new int[sticks.length - 1];
        int h = 0;
        int t = 0;

        int p = 0;
        for (int i = 0; i < sticks.length - 1; i++) {
            int currSum = 0;
            for (int j = 0; j < 2; j++) {
                if (p == sticks.length) {
                    currSum += que[h++];
                } else if (t == h) {
                    currSum += sticks[p++];
                } else {
                    if (sticks[p] > que[h]) {
                        currSum += que[h++];
                    } else  {
                        currSum +=sticks[p++];
                    }
                }
            }
            que[t++] = currSum;
            sum += currSum;
        }
        return sum;
    }
    public static void main(String[] args) {
        _1167_CosttoConnectSticks s = new _1167_CosttoConnectSticks();
        int[] nums = new int[] {2,4,3};
        s.connectSticks(nums);
    }
//    public int connectSticks(int[] sticks) {
//        PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> {
//            return i1 - i2;
//        });
//        Integer[] s = new Integer[sticks.length];
//        for (int i = 0; i <s.length; i ++) {
//            s[i] = sticks[i];
//        }
//        q.addAll(Arrays.asList(s));
//        int sum = 0;
//        while (q.size() >= 2) {
//            int val1 = q.poll();
//            int val2 = q.poll();
//            sum += val1;
//            sum += val2;
//            q.add(val1+val2);
//        }
//        return sum;
//    }
}
