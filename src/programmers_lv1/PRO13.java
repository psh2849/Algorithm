/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/82612
 */
package programmers_lv1;

public class PRO13 {

	static long solution(int price, int money, int count) {
		long ans = 0;
		
		for (int i = 1; i <= count; i++) {
			ans += price * i;
		}
		
		if(ans > money) {
			ans -= money;
		} else {
			ans = 0;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(1, 20, 1);
	}

}
