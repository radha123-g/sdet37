package exapleArrays;

public class PrintAscendingAndDescendingOrder {
 public static void main(String[] args) {
	 int[] a= {6,7,1,0,2,3};
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp=a[i]; 
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("ascending order");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("descending order");
		for(int j=a.length-1;j>=0;j--) {
			System.out.println(a[j]);
		}
}
}
