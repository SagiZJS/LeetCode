package amazon;

import java.util.Arrays;

public class _1099_TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int ret = -1;
        int start = 0;
        int end = A.length - 1;
        while (end > start) {
            int sum = 0;
            sum = A[start] + A[end];
            if (sum < K) {
                if (sum > ret) {
                    ret = sum;
                }
                start++;  
            } else {
                end--;
            }
        }
        return ret;
    }
//    public int twoSumLessThanK(int[] A, int K) {
//        indexInt[] a = new indexInt[A.length];
//        for (int i = 0; i < A.length; i++) {
//            a[i] = new indexInt(A[i], i);
//        }
//        Arrays.sort(a, new Comparator<indexInt>() {
//            @Override
//            public int compare(indexInt o1, indexInt o2) {
//                return o1.val - o2.val;
//            }
//        });
//        int ret = 0;
//        int start=-1;
//        int end = A.length - 1;
//        while (end > 0) {
//            start = 0;
//            int sum = 0;
//            while (start < end) {
//                sum = a[start].val + a[end].val;
//                if (sum < K) {
//                    if (a[start].index < a[end])
//                }
//            }
//        }
//        
//        return ret;
//    }
}
