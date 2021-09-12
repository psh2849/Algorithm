/*
 * https://programmers.co.kr/learn/courses/30/lessons/12910
 */
package programmers_lv1;

import java.util.Arrays;

public class PRO18 {

	static int[] solution(int[] arr, int divisor) {
		int[] answer = new int[arr.length];
		int[] ans;
		int answer_cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				answer[answer_cnt] = arr[i];
				answer_cnt++;
			}
		}
		
		ans = new int[answer_cnt];
		
		if(answer_cnt == 0) {
			ans = new int[1];
			ans[0] = -1;
			return ans;
		}
		
		for(int i = 0; i < answer_cnt; i++) {
			ans[i] = answer[i];
		}
		Arrays.sort(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 9, 7, 10 };
		solution(arr, 5);
	}

}
