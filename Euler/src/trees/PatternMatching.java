package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PatternMatching {

	 public static boolean isMatch2(String text, String pattern) {
	        if (pattern.isEmpty()) return text.isEmpty();
	        boolean first_match = (!text.isEmpty() &&
	                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

	        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
	            return (isMatch2(text, pattern.substring(2)) ||
	                    (first_match && isMatch2(text.substring(1), pattern)));
	        } else {
	            return first_match && isMatch2(text.substring(1), pattern.substring(1));
	        }
	    }
	 
		/*
		 * public static boolean isMatch(String s, String p) { Queue<Character> str =
		 * new LinkedList<>(); Queue<Character> pattern = new LinkedList<>();
		 * 
		 * if (s.length() > 0) { for (int i = 0; i < s.length(); i++) {
		 * str.offer(s.charAt(i)); } }
		 * 
		 * if (p.length() > 0) { for (int i = 0; i < p.length(); i++) {
		 * pattern.offer(p.charAt(i)); } }
		 * 
		 * Character prev = null, pc = null, toMatch=null; boolean wildcardactive =
		 * false; boolean nopoll=false;
		 * 
		 * while (!pattern.isEmpty()) { if (str.isEmpty()) { break; }
		 * 
		 * if (!wildcardactive) { prev = pc; pc = pattern.poll(); }
		 * 
		 * if(!nopoll) toMatch = str.poll();
		 * 
		 * if (pc == toMatch || pc == '.') { prev = pc; nopoll = false; } else if (pc ==
		 * '*' && (prev == toMatch || prev == '*')) { wildcardactive = true; nopoll =
		 * false; } else { wildcardactive = false; nopoll =true; } }
		 * 
		 * 
		 * if (!str.isEmpty()) return false;
		 * 
		 * return true;
		 * 
		 * }
		 */
	public static void main(String[] args) {
		//System.out.println(isMatch("aa", "a"));
		//System.out.println(isMatch("aa", "a*"));
		//System.out.println(isMatch("mississippi", "mis*is*p*."));
		System.out.println(isMatch2("aab", "c*a*b"));
	}

}
