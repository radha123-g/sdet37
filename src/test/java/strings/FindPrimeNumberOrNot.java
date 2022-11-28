package strings;

public class FindPrimeNumberOrNot {
public static void main(String[] args) {
	int i=2,n=19;
	while(i<n) {
		if(n%i==0) {
			break;
		}
		i++;
	}
	if(i==n) {
		System.out.println("no is prime");
	}else
	{
		System.out.println("no is not prime");
	}
}
}
