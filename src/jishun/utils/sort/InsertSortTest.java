package jishun.utils.sort;

import java.util.Arrays;

public class InsertSortTest {

	public static void main(String[] args) {
		someData[] arr = {new someData(0, 1),
				new someData(2, 1),
				new someData(3, 4),
				new someData(1, 5)
				};
		InsertSort.insertSort(arr, (o1, o2)-> ((someData)o1).compareTo(((someData)o2)));
//		InsertSort.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
class someData implements Comparable<someData> {

	private int index;
	private int value;
	public someData(int index, int value) {
		this.index = index;
		this.value = value;
	}
	public int getIndex() {
		return index;
	}
	public int getValue() {
		return value;
	}
	@Override
	public int compareTo(someData o) {
		return getIndex() - o.getIndex();
	}
	@Override
	public String toString() {
		return ""+index+":"+value;
	}
	
	
}
