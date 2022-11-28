package strings;

import java.util.Arrays;

public class StringIsAnagramOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="listen";
		String s2="silent";
		char[] a=s1.toCharArray();
		char[] a1=s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(a1);
		String s3=String.valueOf(a);
		String s4=String.valueOf(a1);
		if(s3.equals(s4)) {
			System.out.println("it is anagram");
		}else {
			System.out.println("it is not anagram");
		}

	}

}
