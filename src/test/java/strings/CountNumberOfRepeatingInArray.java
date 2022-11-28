package strings;

import java.util.LinkedHashSet;

public class CountNumberOfRepeatingInArray {
 public static void main(String[] args) {
	int[] a= {4,1,1,2,3,2};
	LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
	for(int i=0;i<a.length;i++) {
		set.add(a[i]);
	}
	for (Integer n : set) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(n==a[i]) {
				count++;
			}
		}
		System.out.println(n+" "+count);
	}
}
}
