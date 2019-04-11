package hard;

public class _123_Best_Time_to_Buy_and_Sell_Stock_III {
	 public int maxProfit(int[] prices) {
		 if(prices.length==0) return 0;
			int[] p = new int[prices.length-1];
			for(int i=prices.length-1;i>0;i--) {
				p[i-1]=prices[i]-prices[i-1];
			}
			int max = maxProfitSingle(p, 0, p.length-1);
			System.out.println(max);
			int temp=0;
			for(int i=1;i<p.length-1;i++) {
				System.out.println(""+maxProfitSingle(p, 0, i)+" "+maxProfitSingle(p, i+1, p.length-1));
				if(max<(temp=maxProfitSingle(p, 0, i)+maxProfitSingle(p, i+1, p.length-1))) {
					max=temp;
				}
			}
			return max;
	    }
	 public int maxProfitSingle(int[] p,int st,int ed) {
		 if(ed<st) return 0;
			int thisSum=0,maxSum=0;
			for(int i=st;i<ed+1;i++) {
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
		_123_Best_Time_to_Buy_and_Sell_Stock_III t =new _123_Best_Time_to_Buy_and_Sell_Stock_III();
		int[] prices = {1,4,2,7};
		int out=t.maxProfit(prices);
		System.out.println(out);
	}

}
