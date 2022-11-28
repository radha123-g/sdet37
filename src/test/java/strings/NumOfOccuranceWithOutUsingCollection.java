package strings;

public class NumOfOccuranceWithOutUsingCollection {
public static void main(String[] args) {
	String s="welcome";
	char[] str=s.toCharArray();
	int n=str.length; 
	
	for (int i = 0; i < n; i++) {
		int count=1;
		for (int j = i+1; j <n; j++) {
			if (str[i]==str[j]) {
				count++;
				int k=j;
				while(k<n-1) {
					str[k]=str[k+1];
					k++;
				}
				n--;
				j--;
			}
		}
		System.out.println(str[i]+"="+count);
	}
}
}
