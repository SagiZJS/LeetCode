package easy;

import java.util.ArrayList;
import java.util.List;

public class _119_Pascals_Triangle_II {
//public List<Integer> getRow(int rowIndex) {
//	List<Integer> prow =new ArrayList<>();
//	List<Integer> row =new ArrayList<>();
//	rowIndex++;
//	while(rowIndex>0) {
//		rowIndex--;
//		if(prow.size()==0) {
//			prow.add(1);
//			if(rowIndex==0)return prow;
//			continue;
//		}
//		for(int i=0;i<=prow.size();i++) {
//			if(i==0||i==prow.size()) {
//				row.add(1);
//			}else {
//				row.add(prow.get(i-1)+prow.get(i));
//			}
//		}
//		if(rowIndex==0)return row;
//		prow=row;
//		row=new ArrayList<Integer>();
//	}
//	return row;
//    }
	
	public List<Integer> getRow(int rowIndex){
		List<Integer> output = new ArrayList<Integer>();
		output.add(1);
		for(int i=1;i<=rowIndex;i++) {
			for(int j=i;j>0;j--) {
				if(j==i) {
					output.add(1);
				}else {
					output.set(j-1, output.get(j-1)+output.get(j-2));
				}
				
			}
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
