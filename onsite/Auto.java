package onsite;

import java.util.*;

public class Auto {
	class TrieNode{
		HashMap<Character, TrieNode> children;
		String value;
		boolean isword;
		public TrieNode(String value) {
			this.value = value;
			this.children = new HashMap<Character, TrieNode>();
		}
	}
	/**
	 * Question Description. 
	 * Say I'm typing on lete word for the given prefix string
	 */
	
	TrieNode root = new TrieNode("");
	public void insert(String str) {
		TrieNode cur = root;
		for(int i = 0; i < str.length(); i++) {
			if(!cur.children.containsKey(str.charAt(i))) {
				cur.children.put(str.charAt(i), new TrieNode(cur.value + str.charAt(i)));
			}
			cur = cur.children.get(str.charAt(i));
		}
		cur.isword = true;
	}
	public List<String> complete(String prefix) {
		TrieNode cur = root;
		for(char c : prefix.toCharArray()) {
			if(cur.children.containsKey(c))
				cur = cur.children.get(c);
			else
				return null;
		}
		List<String> res = dfs(cur);
 		for(String s : res) {
 			System.out.println(s);
 		}
		return res;
	}
	public List<String> dfs(TrieNode node) {
		List<String> res = new ArrayList<String>();
		if(node == null)
			return null;
		if(node.isword == true)
			res.add(node.value);
		for(char c : node.children.keySet()) {
			res.addAll(dfs(node.children.get(c)));
		}
//		for(Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
//			res.addAll(dfs(entry.getValue()));
//		}
		return res;
	}
	public static void main(String[] args) {
		Auto a = new Auto();
		a.insert("Indeed");
		a.insert("In");
		a.insert("int");
		a.insert("LinkedIn");
		a.insert("Link");
		a.insert("Linked");
		a.complete("in");
	}
}
