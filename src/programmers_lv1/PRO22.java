/*
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
package programmers_lv1;

import java.util.ArrayList;
import java.util.Collections;

public class PRO22 {

	static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i].charAt(n) + strings[i]);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).substring(1,list.get(i).length());
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = { "sun", "bed", "car" };
		solution(strings, 1);
	}

}
