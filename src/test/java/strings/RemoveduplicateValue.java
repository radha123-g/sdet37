package strings;

import java.util.LinkedHashSet;

public class RemoveduplicateValue {
 public static void main(String[] args) {
	String s="hello";
	LinkedHashSet<Character> set = new LinkedHashSet<Character>();	
	for(int i=0;i<s.length();i++) {
		set.add(s.charAt(i));
	}
	System.out.println(set);
	for (Character ch : set) {
		System.out.print(ch);
	}
}
}
