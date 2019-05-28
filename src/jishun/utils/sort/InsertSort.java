package jishun.utils.sort;

import java.util.Comparator;

public class InsertSort {
	
	public static <T> void insertSort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (comparator.compare(arr[j], arr[j - 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}
	public static <T extends Comparable<T>> void insertSort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j].compareTo(arr[j-1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}
	
	

}
