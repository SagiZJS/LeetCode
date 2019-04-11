package easy;
import java.util.*;
public class _118_Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> prow =new ArrayList<>();
		List<Integer> row =new ArrayList<>();
		while(numRows>0) {
			numRows--;
			if(prow.size()==0) {
				prow.add(1);
				output.add(prow);
				continue;
			}
			for(int i=0;i<=prow.size();i++) {
				if(i==0||i==prow.size()) {
					row.add(1);
				}else {
					row.add(prow.get(i-1)+prow.get(i));
				}
			}
			output.add(row);
			prow=row;
			row=new ArrayList<Integer>();
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
