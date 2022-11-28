package example;

import java.util.TreeMap;

public class UsingTreeMap {
 public static void main(String args[]) {
	 TreeMap<Integer, Object> exp=new TreeMap<Integer, Object>();
	 //keys,values
	 exp.put(10, "hi");
	 exp.put(20, "hello");
	 exp.put(102, "bye");
	 exp.put(100, 10);
	 exp.put(102, "hihello");
	 exp.put(105, null);
	// exp.put(null, "xyz");
	// exp.put(null, "abc"); 
	 exp.put(106, null);
	 System.out.println(exp);
	 System.out.println("before removing "+exp);
	 exp.remove(20);
	 System.out.println("after removing "+exp);
     System.out.println(exp.containsKey(102));
     System.out.println(exp.get(102));
     exp.replace(105, null, "excuse");
     System.out.println(exp);
 }
}
