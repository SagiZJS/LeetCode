package medium;

import java.util.ArrayList;
import java.util.List;

public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        if (n == 0) {
            result.add(0);
            return result;
        }
        List<Integer> lastStep = grayCode(n - 1);
        result.addAll(lastStep);
        int a = (int) Math.pow(2, n-1);
        for (int i = lastStep.size() - 1; i >= 0; i--) {
            result.add(a + lastStep.get(i));
        }
        return result;
    }
    
    
    
}
