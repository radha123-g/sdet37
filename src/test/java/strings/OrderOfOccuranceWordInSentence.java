package strings;

import java.util.LinkedHashSet;

public class OrderOfOccuranceWordInSentence {
	public static void main(String[] args) {
		String s="welcom to to bglr city";
		String[] str=s.split(" ");
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<str.length;i++) {
			set.add(str[i]);
		}
		for (String st : set) {
			int count=0;
			for(int i=0;i<str.length;i++) {
				if(st.equals(str[i])) {
					count++;
				}
			}
			for(int j=0;j<str.length;j++) {
				if(st.equals(str[j])) {
					System.out.println(st+" is in "+(j+1)+" position "+count+" times ");
					break;
				}
			}
		}
	}
}
