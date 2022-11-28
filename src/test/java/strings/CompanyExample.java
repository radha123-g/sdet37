package strings;

public class CompanyExample {

	public static void main(String[] args) {
		String s="aaaabbbccddda";
		char[] ch=s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int count=1;
			try {
				while(ch[i]==ch[i+1]) {
					count++;
					i++;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
			System.out.print(count+""+ch[i]);
		}

	}

}
