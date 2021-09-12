/*
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 */
package programmers_lv1;

public class PRO31 {
	static int solution(int n) {
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				answer += i;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
