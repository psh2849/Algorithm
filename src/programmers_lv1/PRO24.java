/*
 * https://programmers.co.kr/learn/courses/30/lessons/12917
 */
package programmers_lv1;

import java.util.ArrayList;
import java.util.Collections;

public class PRO24 {
	static String solution(String s) {
		String answer = "";
		ArrayList<Character> str = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			str.add(s.charAt(i));
		}

		Collections.sort(str, Collections.reverseOrder());

		for (int i = 0; i < str.size(); i++) {
			answer += str.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("Zbcdefg");
	}

}
