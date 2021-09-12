/*
 * https://programmers.co.kr/learn/courses/30/lessons/12912
 */
package programmers_lv1;

public class PRO19 {

	static long solution(int a, int b) {
		long answer = 0;
		
		if(a > b) {
			for(int i = b; i <= a; i++) {
				answer += i;
			}
		} else {
			for(int i = a; i <= b; i++) {
				answer += i;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(3, 5);
	}

}
