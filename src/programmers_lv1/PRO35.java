/*
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */
package programmers_lv1;

import java.util.Arrays;

public class PRO35 {
	static long solution(long n) {
		long answer = 0;
		String str = "" + n;
		long cnt = 1;
		int[] ans = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ans[i] = str.charAt(i);
		}

		Arrays.sort(ans);

		for (int i = 0; i < ans.length - 1; i++) {
			cnt = cnt * 10;
		}

		for (int i = ans.length - 1; i >= 0; i--) {
			answer += cnt * (ans[i] -'0');
			cnt /= 10;
		}
		
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8000000000L);
	}

}
