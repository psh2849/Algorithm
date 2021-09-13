/*
 * https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
 */

package programmers_lv2;

import java.util.*;

public class PRO27 {
	static int position = 0;
	
	static String solution(String p) {
		if(p.isEmpty()) return p;
		
		boolean correct = isCorrect(p);
		String u = p.substring(0, position);
		String v = p.substring(position, p.length());
		
		if(correct) {
			return u + solution(v);
		} 
		String answer = "(" + solution(v) + ")";
		for(int i = 1; i < u.length() - 1; i++) {
			if(u.charAt(i) == '(') {
				answer += ")";
			} else {
				answer += "(";
			}
		}
		
		System.out.println(answer);
		return answer;
	}

	static boolean isCorrect(String str) {
		boolean ret = true;
		int left = 0;
		int right = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;
				if(stack.isEmpty()) {
					ret = false;
				} else {
					stack.pop();
				}
			}
			if(left == right) {
				position = i + 1;
				return ret;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("()))((()");
	}

}
