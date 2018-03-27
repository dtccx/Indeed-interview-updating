package onsite;

import java.util.*;

public class Autobs {
	public int findLeftBound(String[] words, String prefix) {
		int start = 0, end = words.length - 1;
		int mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if(prefix.compareTo(words[mid]) > 0) {
				start = mid + 1;
			}
			else
				end = mid;
		}
		return start;
	}
	public int findRightBound(String[] words, String prefix) {
		int start = 0, end = words.length - 1;
		int mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if(prefix.compareTo(words[mid]) < 0 && 
					(words[mid].length() < prefix.length() || !words[mid].substring(0, prefix.length()).equals(prefix))) {
				end = mid - 1;
			}
			else
				start = mid;
		}
		return end;
	}
	public static void main(String[] args){
		String[] strs = new String[]{"application", "book", "cook", "a", "aap", "app", "boking", "cold"};
		Arrays.sort(strs);
		for(String str : strs){
			System.out.print(str + " ");
		}
		Autobs au = new Autobs();
		//int left = au.findLeftBound(strs, "b");
		//System.out.println(left);
		int right = au.findRightBound(strs, "b");
		System.out.println(right);
//		for(int i = left; i <= right; i++){
//			System.out.println(strs[i]);
//		}
	}
}
