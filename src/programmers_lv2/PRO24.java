/*
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 */
package programmers_lv2;

public class PRO24 {

	static int solution(int n, int a, int b) {
		int answer = 1;

		while (true) {
			for (int i = 1; i <= n; i += 2) {
				if ((i == a && i + 1 == b) || (i == b && i + 1 == a)) {
					return answer;
				}
			}

			int r = a % 2;
			a = a / 2 + r;
			int r2 = b % 2;
			b = b / 2 + r2;

			answer++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8, 4, 7);
	}

}
