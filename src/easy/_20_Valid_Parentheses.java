package easy;

import java.util.Stack;

public class _20_Valid_Parentheses {
	public static boolean isValid(String s) {
		Stack<String> st = new Stack<String>();
		char[] num = s.toCharArray();
		for(char temp:num) {
			if(temp=='('||temp=='{'|temp=='[') {
				st.push(""+temp);
			} else if(st.size()==0){
				return false;
			}
			if(temp==')') {
				char a = st.pop().charAt(0);
				if(a!='(') {
					return false;
				}
			}
			if(temp=='}') {
				char a = st.pop().charAt(0);
				if(a!='{') {
					return false;
				}
			}
			if(temp==']') {
				char a = st.pop().charAt(0);
				if(a!='[') {
					return false;
				}
			}
		}
		if(st.size()!=0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
	}

}
