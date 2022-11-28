package example;

import java.util.ArrayList;

public class exampleTest {
 public static void main(String args[]) {
	 ArrayList<Object> list=new ArrayList<Object>();
	 list.add(10);
	 list.add('A');
	 list.add("hi");
	 list.add(null);
	 list.add(10);
	 list.add(null);
	 list.add("hi");
	 System.out.println(list);
	 
	 ArrayList<Object> list2=new ArrayList<Object>();
	 list2.add('B');
	 list2.add("hello");
	 list2.add(null);
	 list2.add(10);
	 
	 //list.removeAll(list2);//remove all the duplicate value which are present in both arraylist
	 
	 //list.retainAll(list2);//show all the dublicate values which are present in both arraylist
	 
	 if(list.contains('A'))//it will check the element present in the list
	 {
		 System.out.println("present");
	 }
	 else 
	 {
		 System.out.println("not present");
	 }
	 
	 list2.remove(1);//it removes 1st index i.e hello
	 
	 for (Object object : list2) {// printing all the elements present in list2 using for each loop
		 System.out.println(object);
	}
	 
	 System.out.println(list.get(3)); // get the element present in 3rd index of list i.e null
	 
 }
}
