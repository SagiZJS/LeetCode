package medium;

import java.util.Arrays;

public class _338_Counting_Bits {
	public static int[] countBits(int num) {
		int[] output = new int[num+1];
		if(num==0){
			output[0]=0;
			return output;
		}
		output[0]=0;
		output[1]=1;
		int count=2//2^i
				,temp=0;//offset
		for(int i=2;i<=num;i++) {
			if(i>=2*count) {
				count *= 2;
			}
			output[i]=1+output[i-count];
		}
		return output;
	}
	public static int[] countLow(int num) {
		int[] output = new int[num+1];
		for(int i=0;i<=num;i++) {
			int count =0;
			int temp = i;
			while(temp>0) {
				count += temp%2;
				temp = temp/2;
			}
			output[i]=count;
		}
		return output;
	}
	public static void main(String[] args) {
		for(int i =0;;i++) {
			int[] temp1 = countBits(i);
			int[] temp2 = countLow(i);
			for(int j = i;j>=0;j--) {
				if(temp1[j]!=temp2[j]) {
					System.out.println("Error:"+i);
				}
			}
		}
		//System.out.println("Terminated");
	}
}
