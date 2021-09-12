/*
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 */
package programmers_lv1;

public class PRO34 {
	static int[] solution(long n) {
		String str = "" + n;
		int[] answer = new int[str.length()];
		int cnt = 0;
		
		for(int i = str.length() - 1; i >= 0; i--) {
			answer[cnt] = str.charAt(i) - '0';
			cnt++;
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num = 10000000000L;
		solution(num);
	}
}
