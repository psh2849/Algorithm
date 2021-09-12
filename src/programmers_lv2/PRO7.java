/*
 * https://programmers.co.kr/learn/courses/30/lessons/12941
 */
package programmers_lv2;

import java.util.Arrays;

public class PRO7 {

	static int solution(int[] A, int[] B) {
		int answer = 0;
		int cnt = B.length - 1;
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[cnt];
			cnt--;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		solution(A, B);
	}

}
