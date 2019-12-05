package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1102_PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };
        boolean[][] v = new boolean[A.length][A[0].length];
        v[0][0] = true;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -o1[2] + o2[2];
            }
        });
        q.add(new int[] { 0, 0, A[0][0] });
        int max = A[0][0];
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            max = Math.min(max, temp[2]);
            
            int i = temp[0];
            int j = temp[1];
            
            if (i == A.length -1 && j == A[0].length - 1) {
                return max;
            }
            for (int index = 0; index < 4; index++) {
                int nexti = i + dx[index];
                int nextj = j + dy[index];
                if (nexti >=0 &&nexti <A.length 
                 && nextj >=0 &&nextj <A[0].length && !v[nexti][nextj]) {
                    q.add(new int[] {nexti,nextj,A[nexti][nextj]});
                    v[nexti][nextj] = true;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _1102_PathWithMaximumMinimumValue s = new _1102_PathWithMaximumMinimumValue();
        int[][] A = new int[][] { { 5, 4, 5 }, { 1, 2, 6 }, { 7, 4, 6 }

        };
        s.maximumMinimumPath(A);
    }
}
