package easy;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if(prices.length==0) return 0;
		int[] p = new int[prices.length-1];
		for(int i=prices.length-1;i>0;i--) {
			p[i-1]=prices[i]-prices[i-1];
		}
		int thisSum=0,maxSum=0;
		for(int i=0;i<p.length;i++) {
			thisSum+=p[i];
			if(thisSum<0) {
				thisSum=0;
			}
			else if(thisSum>maxSum) {
				maxSum=thisSum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_121_Best_Time_to_Buy_and_Sell_Stock t =new _121_Best_Time_to_Buy_and_Sell_Stock();
		int[] a= {7,1,5,3,6,4};
		System.out.println(t.maxProfit(a));

	}

}
