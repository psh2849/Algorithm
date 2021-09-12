/*
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
package programmers_lv2;

import java.util.ArrayList;

public class PRO21 {

	static int solution(String name) {
		int answer = 0;
		int len = name.length();
		int min = len - 1;
		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			list.add('A');
		}

		for (int i = 0; i < len; i++) {
			if (name.charAt(i) - 'A' > 'Z' - name.charAt(i) + 1) {
				answer += 'Z' - name.charAt(i) + 1;
			} else {
				answer += name.charAt(i) - 'A';
			}
			
			int next = i + 1;
			while(next < len && name.charAt(next) == 'A') {
				next++;
			}
			
			min = Math.min(min, i + len - next + i);
		}
		answer += min;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("BAAAAABBB");
	}

}
