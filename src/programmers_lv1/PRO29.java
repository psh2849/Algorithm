/*
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 */
package programmers_lv1;

public class PRO29 {

	static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);

			if (ch == ' ') {
				answer += (char) ch;
				continue;
			}

			if (ch >= 'a' && ch <= 'z') {
				ch = (s.charAt(i) + n);

				if (ch > 'z') {
					ch = (char) (ch - 26);
				}
			} else {
				ch = (s.charAt(i) + n);

				if (ch > 'Z') {
					ch = (char) (ch - 26);
				}
			}
			
			answer += (char) ch;
			
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("a B z", 4);

	}

}
