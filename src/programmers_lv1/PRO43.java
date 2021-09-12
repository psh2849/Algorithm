/*
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */
package programmers_lv1;

public class PRO43 {

	static String solution(String phone_number) {
		String answer = "";

		for (int i = 0; i < phone_number.length() - 4; i++) {
			answer += "*";
		}

		for (int i = phone_number.length() - 4; i < phone_number.length(); i++) {
			answer += phone_number.charAt(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
