package exapleArrays;

public class FirstMaximumNumberWithoutUsingBubbleSort {
	public static void main(String[] args) {
		int[] a= {3,5,2,5,6};
		int fmin=a[0];
		for(int i=0;i<a.length;i++) {
			if(fmin<a[i]) {
				fmin=a[i];
			}
		}
		System.out.println("first  maximum Num="+fmin);
	}
}
