/*
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */
package programmers_lv1;

public class PRO39 {

	static int[] solution(int n, int m) {
		int[] answer = new int[2];

		if (n <= m) {
			answer[0] = gcd(n, m);
			answer[1] = lcm(n, m);
		} else {
			answer[0] = gcd(m, n);
			answer[1] = lcm(m, n);
		}
	
		return answer;
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
