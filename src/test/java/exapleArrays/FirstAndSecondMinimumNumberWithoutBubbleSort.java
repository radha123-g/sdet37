package exapleArrays;

public class FirstAndSecondMinimumNumberWithoutBubbleSort {

	public static void main(String[] args) {
		int[] a= {3,5,2,5,6};
//		int fmin=a[0];
//		int Smin=a[0 ];
//		for(int i=0;i<a.length;i++) {
//			if(fmin>a[i]) {
//				Smin=fmin;
//				fmin=a[i];
//			} else if(Smin>a[i]) {
//				Smin=a[i];
//			}
//		}
//		System.out.println("first  miniimum Num="+fmin);
//		System.out.println("Second minimum Num="+Smin);
		
		int fmin=0;
		int smin=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]<=fmin) {
				if(a[i]!=fmin) {
				smin=fmin;
			}
			fmin=a[i];
			}
			else if(fmin==smin || smin>a[i]) {
				smin=a[i];
			}
		}
		System.out.println(fmin+" "+smin);
	}

	}


