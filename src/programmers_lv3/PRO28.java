/*
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 */
package programmers_lv3;

public class PRO28 {

	static int solution(String s) {
		int max = 1;
		int len = s.length() - 1;

		for (int i = 0; i < len; i++) {
			max = Math.max(max, find(i, i, s));
			max = Math.max(max, find(i, i + 1, s));
		}
		return max;
	}
	
	static int find(int left, int right, String s) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("abba");
	}

}
