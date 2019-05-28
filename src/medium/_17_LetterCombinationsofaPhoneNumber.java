package medium;

import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> list1 = new ArrayList<>();
		if (digits.length()==0) {
			return list1;
		}
		List<String> list2 = new ArrayList<>();
		list1.add("");
		int index = 0;
		while (index < digits.length()) {
			for (String string : list1) {
				list2.addAll(add(string, digits.charAt(index)));
			}
			list1 = list2;
			list2 = new ArrayList<>();
			index++;
		}
		return list1;
	}

	List<String> add(String origin, char digit) {
		List<String> list = new ArrayList<>();
		switch (digit) {
		case '2':
			list.add(origin + 'a');
			list.add(origin + 'b');
			list.add(origin + 'c');
			break;
		case '3':
			list.add(origin + 'd');
			list.add(origin + 'e');
			list.add(origin + 'f');
			break;
		case '4':
			list.add(origin + 'g');
			list.add(origin + 'h');
			list.add(origin + 'i');
			break;
		case '5':
			list.add(origin + 'j');
			list.add(origin + 'k');
			list.add(origin + 'l');
			break;
		case '6':
			list.add(origin + 'm');
			list.add(origin + 'n');
			list.add(origin + 'o');
			break;
		case '7':
			list.add(origin + 'p');
			list.add(origin + 'q');
			list.add(origin + 'r');
			list.add(origin + 's');
			break;
		case '8':
			list.add(origin + 't');
			list.add(origin + 'u');
			list.add(origin + 'v');
			break;
		case '9':
			list.add(origin + 'w');
			list.add(origin + 'x');
			list.add(origin + 'y');
			list.add(origin + 'z');
			break;
		default:
			break;
		}
		return list;
	}

	public static void main(String[] args) {
		_17_LetterCombinationsofaPhoneNumber s = new _17_LetterCombinationsofaPhoneNumber();
		System.out.println(s.letterCombinations("23"));
	}
}
