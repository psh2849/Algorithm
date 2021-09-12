/*
 * https://programmers.co.kr/learn/courses/30/lessons/12951
 */
package programmers_lv2;

public class PRO8 {

	static String solution(String s) {
		s = s.toLowerCase();
		String answer = "";
		for(int i = 0; i < s.length(); i++) {
			if(i == 0) {
				if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					char ch = (char) (s.charAt(0) - 32);
					answer += ch;
				} else {
					answer += s.charAt(i);
				}
				
			} else {
				if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && s.charAt(i-1) == ' ') {
					answer += (char) (s.charAt(i) - 32);
				} else {
					answer += s.charAt(i);
				}
			}
		}
		
		System.out.println(answer);
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("3people    unFollowed me     ");
	}

}
