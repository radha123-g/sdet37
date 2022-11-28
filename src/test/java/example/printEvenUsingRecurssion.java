package example;

public class printEvenUsingRecurssion {
 public static void call(int i) {
	 if(i<100) {
		 if(i%2==0) {
			 System.out.println(i);
			
		 }
		 i++;
		 printEvenUsingRecurssion.call(i);
	 }
	 
 }
 public static void main(String[] args) {
	printEvenUsingRecurssion.call(1);
}
}
