/*
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 */
package programmers_lv1;

import java.util.Arrays;

public class PRO21 {

	static int solution(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);

		for (int i = 0; i < d.length; i++) {
			if(budget - d[i] >= 0) {
				budget -= d[i];
				answer++;
			}
		}
		
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = { 2,2,3,3 };

		solution(d, 10);
	}

}
