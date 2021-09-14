/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 */
package programmers_lv2;

public class PRO31 {

	static int[] solution(String s) {
		int[] answer = new int[2];
		int len = s.length();
		int save = 0;
		int cnt = 1;
		while (true) {
			len = s.length();
			s = s.replace("0", "");
			save += len - s.length();
			s = Integer.toBinaryString(s.length());

			if (s.length() == 1 && s.charAt(0) == '1')
				break;
			cnt++;
		}
		answer[0] = cnt;
		answer[1] = save;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("110010101001");
	}

}
