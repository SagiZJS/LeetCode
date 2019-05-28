package medium;

public class _983_MinimumCostForTickets {
	int[] cost;
	public int mincostTickets(int[] days, int[] costs) {
		cost = new int[days.length];
		for (int i = 0; i < days.length; i++) {
			int cost1 = costs[0];
			int cost2 = costs[1];
			int cost3 = costs[2];
			
			int index = i;
			while (index >= 0 && days[index] + 0 >= days[i]) {
				index--;
			}
			if (index >= 0) {
				cost1 += cost[index];
			}
			
			index = i;
			while (index >= 0 &&days[index] + 6 >= days[i]) {
				index--;
			}
			if (index >= 0) {
				cost2 += cost[index];
			}
			
			index = i;
			while (index >= 0 &&days[index] + 29 >= days[i]) {
				index--;
			}
			if (index >= 0) {
				cost3 += cost[index];
			}
			
			if (cost1 > cost2) {
				if (cost2 > cost3) {
					cost[i] = cost3;
				} else {
					cost[i] = cost2;
				}
			} else {
				if (cost1 > cost3) {
					cost[i] = cost3;
				} else {
					cost[i] = cost1;
				}
			}
		}
		return cost[days.length - 1];
	}

	

	public static void main(String[] args) {
		_983_MinimumCostForTickets s = new _983_MinimumCostForTickets();
		int[] days = { 1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28
				};
		int[] costs = { 3, 13, 45 };
		System.out.println(s.mincostTickets(days, costs));
	}

}
