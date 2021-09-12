/*
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 */
package programmers_lv1;

public class PRO40 {

	static int solution(int num) {
		int answer = 0;
		int cnt = 0;
		long n = num;
		while (true) {
			System.out.println(num);
			if (n == 1) {
				answer = cnt;
				break;
			}
			if (cnt > 500) {
				answer = -1;
				break;
			}

			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = n * 3 + 1;
			}
			cnt++;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(626331);
	}

}
