package xpathWithFlipkart;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String,Integer> bangloreCity = new HashMap<String,Integer>();
		bangloreCity.put("jayanagar",55);
		bangloreCity.put("btm",56);
		bangloreCity.put("btr",57);
		bangloreCity.put("kattriguppe",58);
		
		HashMap<String,Integer> mysore = new HashMap<String,Integer>();
		mysore.put("vijaynager",5551);
		mysore.put("gandibajar",5552);
		mysore.put("metropol",5553);
		mysore.put("Ramaswamy",5554);
		
		HashMap<String, Integer> gulbarga = new HashMap<String,Integer>();
		gulbarga.put("aland", 585236);
		gulbarga.put("ningadalli", 585237);
		gulbarga.put("mHipparga", 585238);
		gulbarga.put("kerur", 585239);
		
		HashMap<String, HashMap<String, Integer>> karnataka = new HashMap<String, HashMap<String,Integer>>();
		karnataka.put("banglore", bangloreCity);
		System.out.println(karnataka.get("banglore"));
	

	}

}
