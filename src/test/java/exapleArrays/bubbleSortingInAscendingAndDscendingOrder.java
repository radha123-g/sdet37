package exapleArrays;

public class bubbleSortingInAscendingAndDscendingOrder {
	public static void main(String[] args) {
		int[] a= {6,7,1,0,2,3};
		System.out.println("ascending order");
		for(int i=0;i<a.length;i++) {
			// i=0  0<6 ==6
			for(int j=i+1;j<a.length;j++) {
				//j=0+1 ;1<6 ==7
				if(a[i]>a[j]) {
					//0 < 1
					int temp=a[i]; // 0
					a[i]=a[j];// 1
					a[j]=temp;// 0
				}
			}
			System.out.println(a[i]);
			// (7,6,1,0,2,3)
		}
		System.out.println("descending order");
		for(int l=0;l<a.length;l++) {
			for(int k=l+1;k<a.length;k++) {
				if(a[l]<a[k]) {
					int temp=a[l];
					a[l]=a[k];
					a[k]=temp;
				}
			}
			
			System.out.println(a[l]);
		}
	}
}

