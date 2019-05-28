package medium;

public class _12_IntegertoRoman {
	public String intToRoman(int num) {

		StringBuilder output = new StringBuilder();
		// M
		int remaing = num;
		int digit = remaing / 1000;
		remaing = remaing % 1000;
		switch (digit) {
		case 3:
			output.append("M");
		case 2:
			output.append("M");
		case 1:
			output.append("M");
			break;
		default:
			break;
		}
		digit = remaing / 100;
		remaing = remaing % 100;
		switch (digit) {
		case 3:
			output.append("C");
		case 2:
			output.append("C");
		case 1:
			output.append("C");
			break;
		case 4:
			output.append("CD");
			break;
		case 9:
			output.append("CM");
			break;
		case 8:
			output.append("DCCC");
			break;
		case 7:
			output.append("DCC");
			break;
		case 6:
			output.append("DC");
			break;
		case 5:
			output.append("D");
			break;
		default:
			break;
		}
		digit = remaing / 10;
		remaing = remaing % 10;
		switch (digit) {
		case 3:
			output.append("X");
		case 2:
			output.append("X");
		case 1:
			output.append("X");
			break;
		case 4:
			output.append("XL");
			break;
		case 9:
			output.append("XC");
			break;
		case 8:
			output.append("LXXX");
			break;
		case 7:
			output.append("LXX");
			break;
		case 6:
			output.append("LX");
			break;
		case 5:
			output.append("L");
			break;
		default:
			break;
		}
		switch (remaing) {
		case 3:
			output.append("I");
		case 2:
			output.append("I");
		case 1:
			output.append("I");
			break;
		case 4:
			output.append("IV");
			break;
		case 9:
			output.append("IX");
			break;
		case 8:
			output.append("VIII");
			break;
		case 7:
			output.append("VII");
			break;
		case 6:
			output.append("VI");
			break;
		case 5:
			output.append("V");
			break;
		default:
			break;
		}
		return output.toString();
	}
	
	public static void main(String[] args) {
		_12_IntegertoRoman s = new _12_IntegertoRoman();
		System.out.println(s.intToRoman(144));
	}
}
