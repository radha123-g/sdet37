package exapleArrays;

public class FindFirstMinimunNumberAnArrayUsingBubbleSort {
 public static void main(String[] args) {
	int[] a= {6,0,1,2};
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
			if(a[i]>a[j]) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	System.out.println("First minimum number="+a[0]);
	
	
}
}
