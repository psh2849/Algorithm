/*
 * Programmers 'lotto' https://programmers.co.kr/learn/courses/30/lessons/77484 
 */
package programmers_lv1;

import java.util.Arrays;

public class PRO1 {
	
	static int[] lottos = {};
	static int[] win_nums = {};
	static int[] result = { 0, 0 };
	static int cnt = 0;
	static int zero_cnt = 0;

	static public int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		for (int i = 0; i < 6; i++) {
			if(lottos[i] == 0) {
				zero_cnt++;
			}
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) {
					cnt++;
					break;
				}
			}
		}
		
		result[0] = cnt + zero_cnt;
		result[1] = cnt;
		
		if(result[0] == 6) {
			result[0] = 1;
		} else if(result[0] == 5) {
			result[0] = 2;
		} else if(result[0] == 4) {
			result[0] = 3;
		} else if(result[0] == 3) {
			result[0] = 4;
		} else if(result[0] == 2) {
			result[0] = 5;
		} else {
			result[0] = 6;
		}
		
		if(result[1] == 6) {
			result[1] = 1;
		} else if(result[1] == 5) {
			result[1] = 2;
		} else if(result[1] == 4) {
			result[1] = 3;
		} else if(result[1] == 3) {
			result[1] = 4;
		} else if(result[1] == 2) {
			result[1] = 5;
		} else {
			result[1] = 6;
		}
		
		
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = solution(lottos, win_nums);

		System.out.println(ans[0] + " " + ans[1]);

	}

}
