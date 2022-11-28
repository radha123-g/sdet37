package strings;

public class PrimeNumUsingArray {
 public static void main(String[] args) {
	int[] a= {2,3,4,5,6,7};
	for(int i=0;i<a.length;i++) {
		int n=a[i],j=2;
		while(j<n) {
        if(j%n==0) {
        	break;
        }
        j++;
		}
		if(j==n) {
			System.out.println("no is prime");
		}else {
			System.out.println("no is not prime");
		}
	}
}
}
