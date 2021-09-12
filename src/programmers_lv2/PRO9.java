/*
 * https://programmers.co.kr/learn/courses/30/lessons/12939
 */
package programmers_lv2;

import java.util.ArrayList;
import java.util.Collections;

public class PRO9 {

	static String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			list.add(Integer.parseInt(str[i]));
		}

		Collections.sort(list);
		answer += list.get(0) + " " + list.get(list.size() - 1);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("-12 -23 -3 -4");
	}

}
