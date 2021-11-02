/*
 * https://programmers.co.kr/learn/courses/30/lessons/12987
 */
package programmers_lv3;

import java.util.Arrays;

public class PRO26 {

	static int solution(int[] A, int[] B) {
		int answer = 0;
		int cnt = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i < B.length; i++) {
			if(A[cnt] < B[i]) {
				cnt++;
				answer++;
			} else if(A[cnt] > B[i]) {
				continue;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
