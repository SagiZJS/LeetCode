package medium;

public class _8_StringtoInteger_atoi {
	
	static class Solution {
	    public int myAtoi(String str) {
	        if (str == null) return 0;
	        long number = 0;
	        boolean positive = true;
	        boolean firstBitFound = false;
	        for (int i = 0; i < str.length(); i++) {
	        	char temp = str.charAt(i);
	        	int digit = 0;
	        	if (!firstBitFound) {
	        		if (temp == ' ') {
	        			continue;
	        		} else if (temp == '-') {
	        			positive = false;
	        		} else if (temp == '+') {
	        		} else if ((digit = getDigit(temp)) != -1) {
	        			number *= 10;
	        			number += digit;
	        		} else {
	        			return 0;
	        		}
	        		firstBitFound = true;
	        		continue;
	        	}
	        	if ((digit = getDigit(temp)) != -1) {
	        		number *= 10;
	        		number += digit;
	        	} else {
	        		return positive ? ((Long) number).intValue() : -((Long) number).intValue();	
	        	}
	        	if (number > Integer.MAX_VALUE) {
	        		return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        	}
	        }
	        return positive ? ((Long) number).intValue() : -((Long) number).intValue();
	    }
	    
	    private int getDigit(char character) {
	    	if (character <= '9' && character >= '0') {
	    		return character - '0';
	    	} else {
	    		return -1;
	    	}
	    }
	}

	public static void main(String[] args) {
		String[] strs = {
				"1234",
			"-1234",
			"   12345",
			" -0000000000000000000000000000000000123541512634134123612354",
			"-123512341234236523412612354",
			" 0000000000000000000000000000123541234",
			" 0-1",
			" -0000000000000000000000000000000000000000001235412444444444444444444444444444444asdqwe "
		};
		for (String str : strs) {
		int number = new _8_StringtoInteger_atoi.Solution().myAtoi(str);
		System.out.println(number);
		}
	}
	
}
