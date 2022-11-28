package strings;



public class PrintOrderOfOccurance {
 public static void main(String[] args) {
	String s="byebye";
	for(int i=0;i<s.length();i++) {
		System.out.println(s.charAt(i)+" "+(i+1));
	}
	}
}
