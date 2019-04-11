package easy;
import java.math.*;
public class _69_Sqrt_x {
	public static int mySqrt(int x) {
		int i=0;
		for(;i<=46340;i++) {
			System.out.println(i*i);
			if(i*i==x) {
				System.out.println("=");
				return i;
			}
			if(i*i>x) {
				System.out.println(">");
				
				return i-1;
			}
		}
		return 46340;
	}

	public static void main(String[] args) {

		System.out.println(mySqrt(2147483647));
	}

}
