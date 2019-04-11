package easy;


public class _7_Reverse_Integer {
	public static int reverse(int x) {
		boolean nag=(x<0);
		long limit= 4294967296l;
		if(x>limit-1||x<-limit) {
			return 0;
		}
		String out =String.valueOf(nag?-x:x);
		char[] n = out.toCharArray();
		char t;
		int l=n.length;
		for(int i=0 ;i<l/2;i++) {
			t=n[i];
			n[i]=n[l-1-i];
			n[l-1-i]=t;
		}
		out=(nag?"-":"")+new String(n);
		try {
			int output =Integer.parseInt(out);
			return output;
		} catch(Exception e) {
			return 0;
		}
	}
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
