package example;

import java.util.Stack;

public class balancedNUnbalanced {

	public static void main(String[] args) {
		String s="{([])}[]";
		if(isValid(s)) {
			System.out.println(s+"is balanced");
		}else
		{
			System.out.println(s+"is not balanced");
		}

	}
	public static boolean isValid(String s) {
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[') {
				stack.push(s.charAt(i));
			}else if(s.charAt(i)=='}' && stack.peek()=='{') {
				stack.pop();
			}else if(s.charAt(i)==')' && stack.peek()=='(') {
				stack.pop();
			}
			else if(s.charAt(i)==']' && stack.peek()=='[') {
				stack.pop();
			}else
			{
				return false;
			}
		}
		if(stack.isEmpty()) {
			return true;
		}else
		{
			return false;
		}
	}

}
