package easy;

public class _66_Plus_One {
	public int[] plusOne(int[] digits) {
		int digit=digits.length-1;
		while(digit>=0) {
			if(digits[digit]==9) {
				digits[digit]=0;
				digit--;
			} else {
				digits[digit]++;
				break;
			}
		}
		if(digit==-1) {
			int[] output =new int[digits.length+1];
			System.arraycopy(digits, 0, output, 1, digits.length);
			output[0]=1;
			return output;
		}
		return digits;
	}

	public static void main(String[] args) {

	}

}
