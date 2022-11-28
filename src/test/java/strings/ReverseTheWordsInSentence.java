package strings;

public class ReverseTheWordsInSentence {
 public static void main(String[] args) {
	String s="welcome to home";
	String[] st = s.split(" ");
	for(int i=st.length-1;i>=0;i--) {
		System.out.print(st[i]+" ");
	}
}
}
