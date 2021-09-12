package programmers_lv2;

import java.util.Stack;

public class PRO17 {
	
	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		
		return stack.isEmpty() ? true : false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("(())()");
	}

}
