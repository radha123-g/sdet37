package example;

import java.util.Vector;

public class exampleVector {
 public static void main(String args[]) {
	 Vector<String> vec=new Vector<String>();
	 vec.add("car");
	 vec.add("bus");
	 vec.add("cycle");
	 vec.add("bus");
	 System.out.println("size="+vec.size());
	 System.out.println("capacity="+vec.capacity());
	 vec.addElement("train");
	 vec.add("plane");
	 System.out.println(vec);
	 if(vec.contains("cycle")) {
		 System.out.println("present");
	 }else {
		 System.out.println("not present");
	 }
	 vec.remove(3);
	 System.out.println(vec);
	 System.out.println(vec.get(3));
	 System.out.println("========================================================");
	 for(int i=0;i<vec.size();i++) {// fetch all the elements from vector
		 System.out.println(vec.get(i));
	 }
	 for (String value : vec) {
		System.out.println(value);
	}
 }
}
