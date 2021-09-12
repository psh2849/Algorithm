/*
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
package programmers_lv1;

public class PRO16 {

	static String solution(String s) {
		String answer = "";
		int len = s.length();

		if (len % 2 == 0) {
			answer += s.charAt(len / 2 - 1);
			answer += s.charAt(len / 2);
		} else {
			answer += s.charAt(len / 2);
		}
		
		System.out.println(answer);
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("abcde");
	}

}
