package jishun.utils.sort;

import java.util.Arrays;

public class Heap {
	
	private int[] heap;
	
	private int size;
	
	public static void heapSort(int[] nums) {
		Heap heap = new Heap(nums);
		for (int i = nums.length; i > 1; i--) {
			heap.heap[i] = heap.removeTop();
		}
		System.arraycopy(heap.heap, 1, nums, 0, nums.length);
	}
	
	public Heap(int[] nums) {
		heap = new int[nums.length + 1];
		System.arraycopy(nums, 0, heap, 1, nums.length);
		size = nums.length;
		for (int i = nums.length / 2; i > 0; i--) {
			heapify(i);
		}
	}
	
	public void decrease(int i, int num) {
		if (num < heap[i]) {
			throw new IllegalArgumentException();
		}
		heap[i] = num;
		while (i > 1 && heap[parent(i)] < heap[i]) {
			heapSwap(i, parent(i));
			i = parent(i);
		}
		
	}
	
	public void insert(int num) {
		heap[++size] = num;
		decrease(size, num);
	}
	
	public int removeTop() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int top = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return top;
	}
	
	public void heapify(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int min = i;
		if (left <= size && heap[left] > heap[i]) {
			min = left;
		}
		if (right <= size && heap[right] > heap[min]) {
			min = right;
		}
		if (min != i) {
			heapSwap(i, min);
			heapify(min);
		}
		
	}
	private void heapSwap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public int getTop(int[] nums) {
		return nums[1];
	}

	private int parent(int i) {
		return i == 1 ? 0 : i / 2;
	}
	private int leftChild(int i) {
		return i * 2; 
	}
	private int rightChild(int i) {
		return i * 2 + 1; 
	}
	
	public static void main(String[] args) {
		int[] nums = {5,6,1,4,2,3};
		heapSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
