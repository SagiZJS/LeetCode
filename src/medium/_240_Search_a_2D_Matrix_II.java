package medium;

import java.util.Arrays;

public class _240_Search_a_2D_Matrix_II {
	public static boolean searchMatrix(int[][] matrix, int target) {
		for(int i=0;i<matrix.length;i++) {
			System.out.println(i);
			if(BSS(matrix[i], target)) {
				return true;
			}
		}
		return false;
	}
	public static boolean BSS(int[] arr, int target) {
		int i=0,j=arr.length-1;
		while(i<j) {
			System.out.println("i:"+i+"j:"+j+"2:"+(i+j)/2);
			if(target>arr[(i+j)/2]) {
				i=(i+j+1)/2;
			} else if(target<arr[(i+j)/2]) {
				j=(i+j)/2-1;
			} else {
				return true;
			}
		}
		if(arr[i]==target) {
			return true;
		}
		return false;
	}
//	public ToNext BS(int[] arr, int target) {
//		int i=0,j=arr.length-1;
//		while(i!=j) {
//			System.out.println("i:"+i+"j:"+j);
//			if(target>arr[(i+j)/2]) {
//				i=(i+j+1)/2;
//			} else if(target<arr[(i+j)/2]) {
//				j=(i+j)/2;
//			} else {
//				return new ToNext((i+j)/2, true );
//			}
//		}
//		return new ToNext(i,false);
//	}
	class ToNext{
		int i;
		boolean found;
		public ToNext(int i, boolean found) {
			super();
			this.i = i;
			this.found = found;
		}
	}
	public static void main(String[] args) {
//		int[][] a = {
//				{1,4,7,11,15},
//				{2,5,8,12,19},
//				{3,6,9,16,22},
//				{10,13,14,17,24},
//				{28,21,23,26,30},
//		};
		int[][] a={{5}};
		System.out.println(Arrays.toString(a[0]));
		System.out.println(searchMatrix(a, 5));
	}
}
