package easy;

public class _70_Climbing_Stairs {
	public int climbStairs(int n) {
		int[] a = new int[n+1];
		for(int i=0;i<n+1;i++) {
			if(i<2) {
				a[i]=1;
			}else{
				a[i]=a[i-1]+a[i-2];
			}
		}
		return a[n];
	}
}
