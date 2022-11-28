package exapleArrays;

public class SecondMaximunWithoutBubbleSort {
 public static void main(String[] args) {
	 int[] a= {3,2,6,8,5};
	 int fmax=a[0];	
	 int Smax=a[0];
		for(int i=0;i<a.length;i++) {
		if(fmax<a[i]) {
			Smax=fmax;
			fmax=a[i];
		}
		else  if(Smax<a[i]) {
				Smax=a[i];
			}
}
		System.out.println("first maximum num="+fmax+"\nSecond maximum Num="+Smax);
}
}
