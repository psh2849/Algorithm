/*
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
package programmers_lv1;

public class PRO42 {
	
	static boolean solution(int x) {
		boolean answer = true;
		int sum = 0;
		int ans = x;
		while(x > 0) {
			int num = x % 10;
			sum += num;
			x = x / 10;
		}
		
		if(ans % sum == 0) {
			answer = true;
		} else {
			answer = false;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
