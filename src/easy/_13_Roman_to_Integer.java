package easy;

public class _13_Roman_to_Integer {
	public int romanToInt(String s) {
		char[] num =s.toCharArray();
		int value=0;
		for(int i=0;i<num.length;i++) {
			char temp=num[i],
					next=(i<num.length-1?num[i+1]:'0');
			if(i<num.length-1&&RTI(temp)<RTI(next)) {
				i++;
				value+=RTI(next)-RTI(temp);
			} else {
				value+=RTI(temp);
			}
		}
		return value;
	}
	int RTI(char input) {
		if(input=='I')return 1;
		if(input=='V')return 5;
		if(input=='X')return 10;
		if(input=='L')return 50;
		if(input=='C')return 100;
		if(input=='D')return 500;
		if(input=='M')return 1000;
		return 0;
	}
}
