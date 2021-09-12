/*
 * https://programmers.co.kr/learn/courses/30/lessons/12924
 */
package programmers_lv2;

public class PRO12 {
	
	static int solution(int n) {
		int answer = 0;
		
		int left = 0;
		int right = 0;
		int sum = 0;
		

		while(right <= n) {
			if(sum > n) {
				sum -= left;
				left++;
			} else {
				right++;
				sum += right;
			}
			if(sum == n) {
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(15);
	}

}
