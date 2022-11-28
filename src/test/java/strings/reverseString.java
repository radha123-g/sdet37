package strings;



public class reverseString {
	public static void main(String[] args) {
		//1st
		String s="beautiful";
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}

		//2nd using tochararray
		char[] st=s.toCharArray();
		for(int j=s.length()-1;j>=0;j--) {
			System.out.print(st[j]);
		}

		//3rd using 3rd variable
		String rev=" ";
		for(int k=s.length()-1;k>=0;k--) {
			rev=rev+s.charAt(k);
		}
		System.out.println(rev);

		//4th using count
		char[] str=s.toCharArray();
		int count=0;
		for (char c : str) {
			count++;
		}
		for(int l=count-1;l>=0;l--) {
			System.out.print(str[l]);
		}

		//5th using stringBuffer
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		System.out.print(sb);
		
		//using while loop
		String r="radha";
		int i=r.length()-1;
		while(i>=0) {
			System.out.print(r.charAt(i--));
		
		}
	}
}
