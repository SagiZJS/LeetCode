package easy;

public class _461_Hamming_Distance {
	public int hammingDistance(int x, int y) {
		x = x^y;
		int count=0;
		while(x!=0) {
			count += x%2==1?1:0;
			x=x/2;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1^3);

	}

}
