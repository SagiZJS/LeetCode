package medium;

public class _29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; 
		if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE; 
		if (dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE; 
		if (dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE+1;
		if (dividend == Integer.MAX_VALUE || dividend == -Integer.MAX_VALUE) {
			if (divisor == 1 || divisor == -1) {
				return dividend*divisor;
			}
		}
		if (divisor == Integer.MIN_VALUE) {
			if (dividend == Integer.MIN_VALUE) return 1;
			else return 0;
		}
		int positive = 1;
		if (divisor<0) {
			positive *=-1;
		}
		int res = 0;
		if (divisor == 2) {
			res = dividend>>1;
			res *= positive;
		} else {
			boolean flag = false;
			if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
				flag = true;
				divisor = -divisor;
			}
			if (dividend > 0) {
				while (dividend > 0) {
					dividend-=divisor;
					if (dividend>=0) {
						res++;
					}
				}
			} else {
				while (dividend<0) {
					dividend-=divisor;
					if (dividend<=0) {
						res++;
					}
				}
			}
			if (flag) {
				res = -res;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		_29_DivideTwoIntegers s = new _29_DivideTwoIntegers();
//		System.out.println(s.divide(Integer.MAX_VALUE, 1));
		System.out.println(Integer.MIN_VALUE>>1);
	}
}
