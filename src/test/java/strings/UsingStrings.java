package strings;

public class UsingStrings {
 public static void main(String[] args) {
	String s="bangalore";
	System.out.println(s.length());
	
	String s1="bangalore";
	char[] str=s1.toCharArray();
	System.out.println(str.length);
	
	String s3="bangalore";
	System.out.println(s3.charAt(0));
	
	String s4="bagalakot";
	System.out.println(s4.indexOf('g'));
	
	String s5="pen";
	String s6="phone";
	System.out.println(s5.equals(s6));
	
	String s7="apple";
	String s8="grapes";
	System.out.println(s7.compareTo(s8));
	
	String s9="jalahalli";
	String s10 = "peenya";
	String s11 = "dasarahalli";
	System.out.println(s9.concat(s10).concat(s11));
	
	String a="hi";
	String b = "hello";
	String c = "bye";
	String joined = String.join(" ", a,b,c);
	System.out.println(joined);
	
	String d="bangalore";
	System.out.println(d.contains("lo"));
	 
	System.out.println(d.startsWith("ba"));
	
	System.out.println(d.endsWith("re"));
	
	String e="cutie";
	String f="";
	System.out.println(f.isBlank());
	
	System.out.println(f.isEmpty());
	
	String g="DaSaRaHALLI";
	System.out.println(g.toLowerCase());
	
	String h="DaSaRaHALLI";
	System.out.println(h.toUpperCase());
	
	String i="DaSaRaHALLI";
	System.out.println(i.replace('D', 'd'));
	
	String j="Hi DaSaRaHALLI";
    System.out.println(j.trim());
    
    String k="Hi Hello DaSaRaHALLI";
    System.out.println(k.replace(" ", ""));
    
    String l="hi hello DaSaRaHALLI";
    String[] str1=l.split(" ");
    for(int m=0;m<str1.length;m++) {
    	System.out.println(str1[m]);
    }
    
    String n="dasarahalli";
    System.out.println(n.substring(0, 4));//dasa
}
}
