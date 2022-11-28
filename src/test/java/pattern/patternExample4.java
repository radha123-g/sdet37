package pattern;

public class patternExample4 {

	public static void main(String[] args) {
		int n=7;
		for (int i =n; i >0; i--) {
			for (int j = n; j>0; j--) {
				if(i>=j) {
				System.out.print("* ");
			}else {
				System.out.print(" ");
			}
			
		}
			System.out.println(); 
	}

	}

}
