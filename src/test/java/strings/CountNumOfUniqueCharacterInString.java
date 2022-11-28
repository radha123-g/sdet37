package strings;

import java.util.LinkedHashSet;

public class CountNumOfUniqueCharacterInString {
public static void main(String[] args) {
	String s="hello";
	LinkedHashSet<Character> set = new LinkedHashSet<Character>();	
	for(int i=0;i<s.length();i++) {
		set.add(s.charAt(i));
	}
	System.out.println(set);
	for (Character ch : set) {
		int count=0;
		for(int j=0;j<s.length();j++) {
			if(ch==s.charAt(j)) {
				count++;
			}
		}
		if(count==1) {
		System.out.println(ch+" "+count);
	}
}
}
}
