/*
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
package programmers_lv2;

public class PRO1 {

	static int solution(String s) {
		int answer = s.length();
		
		for (int i = 1; i <= s.length() / 2; i++) {
			int len = compress(s, i).length();
			answer = Math.min(answer, len);
		}

		return answer;
	}

	static String compress(String str, int i) {
		int cnt = 1;
		String compression = "";
		String pattern = "";
		
		for(int j = 0; j <= str.length() + i; j += i) {
			String nowStr;
			
			if(j >= str.length()) {
				nowStr = "";
			} else if(str.length() < j + i) {
				nowStr = str.substring(j);
			} else {
				nowStr = str.substring(j, j + i);
			}
			
			if(j != 0) {
				if(nowStr.equals(pattern)) {
					cnt++;
				} else if(cnt >= 2) {
					compression += cnt + pattern;
					cnt = 1;
				} else {
					compression += pattern;
				}
			}
			
			pattern = nowStr;
		}
		
		return compression;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
