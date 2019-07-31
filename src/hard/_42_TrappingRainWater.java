package hard;

public class _42_TrappingRainWater {
//    public int trap(int[] height) {
//        if (height.length == 0) {
//            return 0;
//        }
//        int trend = 0; // 0 find next peak without recording 1: looking for next peak while recording
//                       // -1: going down
//
//        int lastHeightPeak = height[0];
//        int lastHeight = height[0];
//        int lastInedx = 0;
//
//        int sum = height[0];
//        int sumWater = height[0];
//
//        for (int i = 1; i < height.length; i++) {
//            int tempHeight = height[i];
//            sum += tempHeight;
//
//            if (tempHeight > lastHeight) {
//                if (trend == 0) {
//                    // finding peak;
//                    lastHeightPeak = tempHeight;
//                }
//                if (trend == 1) {
//                    // looking for bottom peak
//                    if (lastHeightPeak < tempHeight) {
//                        // got bottom peak
//                        lastHeightPeak = tempHeight;
//                        trend = 0;
//                    }
//                }
//                if (trend == -1) {
//                    // turn up
//                    trend = 1;
//                }
//
//            }
//            if (tempHeight == lastHeight) {
//                if (trend == 0) {
//                }
//                if (trend == 1) {
//                }
//                if (trend == -1) {
//                }
//            }
//            if (tempHeight < lastHeight) {
//                if (trend == 0) {
//                    // looking peak
//                    lastInedx = i - 1;
//                    lastHeightPeak = lastHeight;
//                    trend = -1;
//                }
//                if (trend == 1) {
//                    // find the actual water capacity need to modify
////                    if (lastHeight < lastHeightPeak) {
////                        int x = lastHeightPeak - lastHeight;
////                        int y = (i - 1) - lastInedx;
////                        sumWater -= x * y;
////                        lastInedx = i - 1;
////                        lastHeightPeak = lastHeight;
////                        trend = -1;
////                    }
//                }
//                if (trend == -1) {
//                    // nothing
//                }
//            }
//            if (i == height.length - 1) {
//                if (tempHeight < lastHeightPeak && trend != 0) {
//                    int x = lastHeightPeak - tempHeight;
//                    int y = (i) - lastInedx;
//                    sumWater -= x * y;
//                    lastInedx = i;
//                    lastHeightPeak = lastHeight;
//                }
//            }
//            sumWater += lastHeightPeak;
//            lastHeight = tempHeight;
//        }
//        return sumWater - sum;
//    }
    public int trap(int[] height) {
        int[] peak = new int[height.length];
        int trend = 0;
        int count = -1;
        int sum = 0;
        for (int i = 0; i < peak.length - 1; i++) {
            if (height[i + 1] < height[i]) {
                peak[++count] = i;
                trend = -1;
                break;
            }
        }
        if (count == -1) {
            return 0;
        }
        for (int i = peak[count] + 1; i < height.length - 1; i++) {
            int tempHeight = height[i];
            if (trend == 1 && height[i] > height[i + 1]) {
                trend = -1;
                while (count > 0 && tempHeight >= height[peak[count]]) {
                    int middle = height[peak[count]];
                    int first = height[peak[count - 1]];
                    if (middle < first) {
                        count--;
                    } else {
                        break;
                    }
                }
                peak[++count] = i;
            } else if (trend == -1 && height[i] < height[i + 1]) {
                trend = 1;
            }
        }
        if (height[height.length - 1] >= height[height.length - 2]) {
            while (count > 0 && height[height.length - 1] > height[peak[count]]) {
                int middle = height[peak[count]];
                int first = height[peak[count - 1]];
                if (middle < first) {
                    count--;
                } else {
                    break;
                }
            }
            peak[++count] = height.length - 1;
        }

        if (count < 1) {
            return 0;
        }
        sum = 0;
        int i = peak[count];
        int rH = height[peak[count--]];
        while (count >= 0) {
            int lH = height[peak[count]];
            int min = lH < rH ? lH : rH;
            while (i >= peak[count]) {
                if (height[i] < min) {
                    sum += (min - height[i]);
                }

                i--;
            }
            count--;
            rH = lH;
        }

        return sum;
    }

    public static void main(String[] args) {
        _42_TrappingRainWater s = new _42_TrappingRainWater();
        int[] height =
//                 {2,1,3}
//                { 5, 4, 1, 2 }
//        {0,1,0,2,1,0,1,3,2,1,2,1}
//                { 5, 2, 1, 2, 1, 5 }
//        {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}
//            {2,8,5,5,6,1,7,4,5}
//            {1,9,7,1,3,6,4,7,4,8,3,6,3,5,3,7}
                { 4, 7, 7, 5, 3, 3, 4, 9, 5, 8, 6, 2, 0, 6, 2, 7, 4 };
// 1 + 2+5 +1 +1
        //
        System.out.println(s.trap(height));
    }
}
