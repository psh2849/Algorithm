/*
 * https://programmers.co.kr/learn/courses/30/lessons/87389
 */
package programmers_lv1;

public class PRO48 {
	
	static int solution(int n) {
		int answer = 0;
		
		for(int i = 1; i <= 1000000; i++) {
			if(n % i == 1) {
				answer = i;
				break;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10);
	}

}
