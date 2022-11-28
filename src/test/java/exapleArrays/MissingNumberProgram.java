package exapleArrays;

public class MissingNumberProgram {

	public static void main(String[] args) {
     int a[]= {2,3,5,7,8,11,14};
     int b[]=new int[15];
     for (int i : a) {
		b[i]=1;
	}
     for (int i = 2; i < b.length; i++) {
		if(b[i]==0) {
		System.out.print(" "+i);
	}
     }
     
   //another way
     int c[]= {2,3,5,7,8,11,14};
     for (int i = 0; i < c.length-1; i++) {
		int d=a[i+1]-a[i];
		int count=1;
		while(d>1) {
			System.out.print(a[i]+count+" ");
		    count++;
		    d--;
		}
	}
     
	}

}
