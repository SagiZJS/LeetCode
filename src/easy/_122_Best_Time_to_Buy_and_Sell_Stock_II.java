package easy;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
	/**
	 * wrong solution
	 * @param prices
	 * @return
	 */
//	public int maxProfit(int[] prices) {
//		if(prices.length==0) return 0;
//		int[] p = new int[prices.length-1];
//		for(int i=prices.length-1;i>0;i--) {
//			p[i-1]=prices[i]-prices[i-1];
//		}
//		int oddSum=0,evenSum=0,maxSum=0;
//		for(int i=0;i<p.length;i++) {
//			if(p[i]>0) {
//				if(i%2==0) {
//					evenSum+=p[i];
//				}else {
//					oddSum+=p[i];
//				}
//			} else {
//					maxSum+=oddSum>evenSum?oddSum:evenSum;
//					oddSum=0;
//					evenSum=0;
//			}
//		}
//		if(oddSum>0||evenSum>0) {
//			maxSum+=oddSum>evenSum?oddSum:evenSum;
//		}
//		return maxSum;
//	}
	public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
		int[] p = new int[prices.length-1];
		for(int i=prices.length-1;i>0;i--) {
			p[i-1]=prices[i]-prices[i-1];
		}
		int maxSum=0;
		for(int i=0;i<p.length;i++) {
			if(p[i]>0) {
                maxSum+=p[i];
			}
		}

		return maxSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
