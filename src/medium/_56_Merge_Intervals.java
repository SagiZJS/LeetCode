package medium;

import java.util.Arrays;
import java.util.Comparator;

public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][];
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals; 
        }
        int count = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
            }

        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                // overlap do something
                intervals[i + 1][0] = intervals[i][0];
                if (intervals[i][1] > intervals[i + 1][1]) {
                    intervals[i + 1][1] = intervals[i][1];
                }
            } else {
                result[count++] = intervals[i];
            }
        }
        result[count++] = intervals[intervals.length - 1];
        return Arrays.copyOf(result, count);
    }

}
