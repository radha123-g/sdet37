package strings;

import java.util.LinkedHashSet;

public class CountUniqueWordsInSentence {
 public static void main(String[] args) {
	String s="welcom to to bglr city";
	String[] st=s.split(" ");
	LinkedHashSet<String> set=new LinkedHashSet<String>();
	for(int i=0;i<st.length;i++) {
		set.add(st[i]);
	}
	for (String str : set) {
		int count=0;
	 for(int j=0;j<st.length;j++) {
		 if(str.equals(st[j])) {
			 count++;
		 }
	 }
	 if(count==1) {
		 System.out.println(str+" "+count);
	 }
	}
}
}
