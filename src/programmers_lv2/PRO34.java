/*
 * https://programmers.co.kr/learn/courses/30/lessons/84512
 */
package programmers_lv2;

public class PRO34 {
	static int solution(String word) {
		int answer = 0;
		char[] str = word.toCharArray();
		int cnt = str.length;
		int[] mul = { 781, 156, 31, 6, 1 };

		while (cnt > 0) {
			if(str[str.length - cnt] == 'A') {
				answer += mul[str.length - cnt] * 0 + 1;
			} else if(str[str.length - cnt] == 'E') {
				answer += mul[str.length - cnt] * 1 + 1;
			} else if(str[str.length - cnt] == 'I') {
				answer += mul[str.length - cnt] * 2 + 1;
			} else if(str[str.length - cnt] == 'O') {
				answer += mul[str.length - cnt] * 3 + 1;
			} else {
				answer += mul[str.length - cnt] * 4 + 1;
			}
			cnt--;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
