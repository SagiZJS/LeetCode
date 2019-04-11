package easy;

public class _38_Count_and_Say {
	public static String countAndSay(int n) {
		String output = "1";
		while(n>1) {
			output=count(output);
			n--;
		}
		return output;
    }
	static String count(String input) {
		char temp =input.charAt(0);
		int count=0;
		String output="";
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)==temp) {
				count++;
			} else {
				output =output+count+temp;
				temp=input.charAt(i);
				count=1;
			}
		}
		output =output+count+temp;
		count=1;
		return output;
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
