package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class _973_KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0] + o1[1]*o1[1])
                     - (o2[0]*o2[0] + o2[1]*o2[1]);
            }
        });
        return Arrays.copyOf(points, K);
    }
}
