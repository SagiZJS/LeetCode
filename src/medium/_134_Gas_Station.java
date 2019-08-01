package medium;

public class _134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }
        int[] gasDiff = new int[gas.length];
        for (int i = 0; i < gasDiff.length; i++) {
            gasDiff[i] = gas[i] - cost[i];
        }
        int index = 0;
        int maxIndex = 0;
        int sum = 0;
        int maxSum = 0;
        for (int j = 0; j < gasDiff.length * 2 - 1; j++) {
            int i = (j >= gasDiff.length?j-gasDiff.length:j);
            sum += gasDiff[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = index;
            }
        }
        if (isValid(gasDiff, maxIndex)) {
            return maxIndex;
        } else {
            return - 1;        
        }
    }
    public boolean isValid(int[] gasDiff, int maxIndex) {
        int sum = 0;
        int index = maxIndex;
        while (true) {
            sum += gasDiff[index];
            if (sum < 0) {
                return false;
            }
            index++;
            if (index == gasDiff.length) {
                index = 0;
            }
            if (index == maxIndex) {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas = { 3,1,1  };
        int[] cost = { 1,2,2 };
        _134_Gas_Station s = new _134_Gas_Station();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
