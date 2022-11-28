package example;

import java.util.Hashtable;

public class HashTableExample {
 public static void main(String[] args) {
	Hashtable<Integer, Object> map=new Hashtable<Integer, Object>();
	map.put(10, "hi");
	map.put(100, 10);
	map.put(102, "bye");
	map.put(103, "bye");// duplicate values are allowed
	map.put(102, "hihello");//duplicates keys not allowed
	map.put(105, "hello");
//	map.put(null, 104);//not allowed
//	map.put(106, null);//not allowed
	System.out.println("before removing"+map);
	map.remove(103);
	System.out.println("after removing"+map);
	System.out.println(map.containsKey(102));//true
	System.out.println(map.get(100));//10
	map.replace(105, "hello","sanjay");//replace old value with new value
	System.out.println(map);
}
}
