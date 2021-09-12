/*
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
package programmers_lv1;

public class PRO23 {
	
	static boolean solution(String s) {
		int p_cnt = 0;
		int y_cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
				p_cnt++;
			} else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
				y_cnt++;
			}
		}
		
		if(p_cnt == y_cnt) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("pPoooyY");
	}

}
