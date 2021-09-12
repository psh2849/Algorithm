/*
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 */
package programmers_lv1;

public class PRO25 {

	static boolean solution(String s) {
		boolean answer = true;
		int len = s.length();
		
		if (len != 4 && len != 6) {
			answer = false;
			return answer;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				answer = false;
				return answer;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ans = solution("a234");
		System.out.println(ans);
	}

}
