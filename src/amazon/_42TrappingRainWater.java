package amazon;

public class _42TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sumHeight = 0;

        int maxHeight = 0;
        int maxIndex = -1;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
            sumHeight += height[i];
        }
        int forwardRoundSum = 0;
        int maxForwardHeight = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > maxForwardHeight) {
                maxForwardHeight = height[i];
            }
            forwardRoundSum += maxForwardHeight;
        }

        int backwardRoundSum = 0;
        int maxBackwardHeight = 0;
        for (int i = height.length - 1; i >= maxIndex; i--) {
            if (height[i] > maxBackwardHeight) {
                maxBackwardHeight = height[i];
            }
            backwardRoundSum += maxBackwardHeight;
        }

        return forwardRoundSum + backwardRoundSum - sumHeight;
    }
}
