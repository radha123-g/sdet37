package exapleArrays;

public class AddTwoArrays {

	public static void main(String[] args) {
		int[] a= {2,3,1,4,2};
		int[] b= {1,2,3,1,8,4};
		int c;
		int len=a.length;
		if(a.length < b.length) {
			len=b.length;
		}
		for(int i=0;i<len;i++) {
            try {
			  c=a[i]+b[i];
				System.out.println(c);
            }catch (Exception e) {
				if(a.length<b.length) {
					System.out.println(b[i]);
				}else
				{
					System.out.println(a[i]);
				}
			}
		}
	}

}
