/*
 * https://programmers.co.kr/learn/courses/30/lessons/76502
 */
package programmers_lv2;

import java.util.Stack;

public class PRO35 {
	static Stack<Character> stack = new Stack<>();
	
	static int solution(String s) {
		int answer = 0;
		int len = s.length();
		
		while(len > 0) {
			boolean flag = pro(s);
			
			if(flag) {
				answer++;
			}
			
			s = rotate(s);
			len--;
		}
		
		System.out.println(answer);
		return answer;
	}
	
	static boolean pro(String s) {
		boolean flag = true;
		stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if(stack.isEmpty()) {
					flag = false;
					break;
				}
				
				char ch = stack.pop();
				if(s.charAt(i) == ')') {
					
					if(ch != '(') {
						flag = false;
						break;
					}
				} else if(s.charAt(i) == '}') {
					if(ch != '{') {
						flag= false;
						break;
					}
				} else if(s.charAt(i) == ']') {
					if(ch != '[') {
						flag= false;
						break;
					}
				}
			}
		}
		
		if(!stack.isEmpty()) {
			flag = false;
		}
		
		if(!flag) {
			return false;
		} else {
			return true;
		}
	}
	
	static String rotate(String s) {
		Character[] str = new Character[s.length()];
		char temp = s.charAt(0);
		
		for(int i = 0; i < s.length(); i++) {
			str[i] = s.charAt(i);
		}
		
		for(int i = 0; i < s.length() - 1; i++) {
			str[i] = str[i+1];
		}
		
		str[s.length() - 1] = temp;
		
		s = "";
		for(int i = 0 ; i < str.length; i++) {
			s += str[i];
		}
		
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("[");
	}

}
