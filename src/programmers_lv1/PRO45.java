/*
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
package programmers_lv1;

public class PRO45 {

	static long[] solution(int x, int n) {
		long[] answer = new long[n];
		int cnt = 0;
		long num = x;
		for (int i = n - 1; i >= 0; i--) {
			answer[cnt] = num;
			num = num + x;
			System.out.println(answer[cnt]);
			cnt++;
		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(-4, 2);
	}

}
