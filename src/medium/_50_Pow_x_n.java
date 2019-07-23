package medium;

//import java.util.Random;

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        long m = n;
        double[] intermediate = new double[40];
        intermediate[0] = x;
        double res = 1;
        int count = 0;
        long base = 1;
        int bit = 0;
        boolean negative = false;
        if (m < 0) {
            negative = true;
            m = -m;
        }
        while (true) {
            if (base * 2 <= m) {
                intermediate[count + 1] = intermediate[count] * intermediate[count];
                base *= 2;
                count++;
            } else {
                break;
            }
        }
        while (true) {
            if (m % 2 == 1) {
                res *= intermediate[bit];
            }
            m = m >> 1;
            if (m == 0) {
                break;
            }
            bit++;
        }
        if (negative) {
            res = 1 / res;
        }
        return res;
    }

    public static void main(String[] args) {
        _50_Pow_x_n s = new _50_Pow_x_n();
        s.myPow(2, Integer.MIN_VALUE);
        
//        Random random = new Random();
//        while (true) {
//            double x = random.nextDouble();
//            if (x > 100 || x < -100) {
//                continue;
//            }
//
//            int n = random.nextInt(Integer.MAX_VALUE);
//            System.out.println(""+x+": "+n);
//            double a = s.myPow(x, n);
//            double b = Math.pow(x, n);
//            if (a != b) {
//
//                System.out.println(a + " " + b);
//                break;
//            }
//        }
    }
}
