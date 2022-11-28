package strings;

public class FindTheMinLengthInTheStringaArray {

	public static void main(String[] args) {
		String[] i= {"abc","abcd","abcef","ab"};
	    String min=i[0];
	    for (int j = 0; j < i.length; j++) {
			if (min.length()>i[j].length()) {
				min=i[j];
			}
		}
	   for (int j = 0; j < i.length; j++) {
		if (min.length()==i[j].length()) {
			System.out.println(i[j]);
		}
	}
 
	}

}
