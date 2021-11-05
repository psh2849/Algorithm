/*
 * https://programmers.co.kr/learn/courses/30/lessons/12946
 */
package programmers_lv3;

import java.util.ArrayList;

public class PRO31 {
	
	static ArrayList<int[]> list;
	static int[][] solution(int n) {
		list = new ArrayList<>();

		hanoi(n, 1, 3, 2);
		int[][] answer = new int[list.size()][2];
		for(int i = 0; i < list.size(); i++) {
			int[] ans = list.get(i);
			answer[i][0] = ans[0];
			answer[i][1] = ans[1];
		}
		return answer;
	}
	
	static void hanoi(int n, int start, int to, int mid) {
		int[] result = {start, to};
		if(n == 1) {
			list.add(result);
		} else {
			hanoi(n - 1, start, mid, to);
			list.add(result);
			hanoi(n - 1, mid, to, start);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(2);
	}

}
