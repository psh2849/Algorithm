/*
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 */
package programmers_lv2;

public class PRO29 {
	
	static int solution(int n) {
		int ans = 0;
	
		while(n != 0) {
			if(n % 2 == 0) {
				n /= 2;
			} else {
				n--;
				ans++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5000);
	}

}
