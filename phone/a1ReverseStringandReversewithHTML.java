package IndeedPhone;
import java.util.*;
public class a1ReverseStringandReversewithHTML {
	public void reverseString(String input) {
		char[] str = input.toCharArray();
		reverse(str, 0, str.length - 1);
		int k = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i] == ' ') {
				reverse(str, k, i - 1);
				k = i + 1;
			}
		}
		reverse(str, k, str.length - 1);
		input = String.valueOf(str);
	}
	public void reverse(char[] str, int i, int j) {
		while(i < j) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
	}
	
	public void reverseHTML(String input) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) != '&' || (input.charAt(i) == '&' && i < input.length() - 1 && input.charAt(i + 1) == '&')) {
				list.add(String.valueOf(input.charAt(i)));
				//System.out.println("index: " + i);
			} else {
				int k = i + 1;
				for(; k < input.length(); k++) {
					if(input.charAt(k) == ';') {
						break;
					}
				}
				if(k == input.length()) {
					list.add(String.valueOf(input.charAt(i)));
					continue;
				}
				list.add(input.substring(i, k + 1));
				i = k;
			}
		}
		System.out.println(list);
		String[] str = reverseHelper(list);
		StringBuilder sb = new StringBuilder();
		for(String s : str) {
			System.out.println(s);
			sb.append(s);
		}
		input = sb.toString();
		System.out.println(input);
	}
	public String[] reverseHelper(List<String> list) {
		String[] str = new String[list.size()];
		int i = 0, j = list.size() - 1;
		while(i <= j) {
			str[i] = list.get(j);
			str[j] = list.get(i);
			i++;
			j--;
		}
		return str;
	}
 }
