/*
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */
package programmers_lv2;

import java.util.Stack;

public class PRO5 {

	static int solution(String s) {
		int answer = -1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.size() == 0) {
				stack.push(s.charAt(i));
			} else {
				if (stack.peek() == s.charAt(i)) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}

		if (stack.size() == 0) {
			answer = 1;
		} else {
			answer = 0;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("baabaa");
	}

}
