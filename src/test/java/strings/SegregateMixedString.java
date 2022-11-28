package strings;

public class SegregateMixedString {
	public static void main(String[] args) {
		String s="a1b$c2/3&";
		String alpha=" ";
		String spc=" ";
		String Num=" ";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='a' && s.charAt(i)<='z') {
				alpha=alpha+s.charAt(i);
			}
			else if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				Num=Num+s.charAt(i);
			}
			else {
				spc=spc+s.charAt(i);
			}
		}
		System.out.println(alpha);
		System.out.println(Num);
		System.out.println(spc);
	}
}
