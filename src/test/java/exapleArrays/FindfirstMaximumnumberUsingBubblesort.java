  package exapleArrays;

public class FindfirstMaximumnumberUsingBubblesort {
public static void main(String[] args) {
	int[] a= {0,9,1,2};
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
			if(a[i]<a[j]) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	System.out.println("First maximum number="+a[0]);
	
	
}


}

