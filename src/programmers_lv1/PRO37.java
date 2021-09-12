/*
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */
package programmers_lv1;

public class PRO37 {
	static int[] solution(int[] arr) {
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		int[] answer = new int[1];

		if (arr.length == 1) {
			answer[0] = -1;
			return answer;
		}

		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		answer = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != min) {
				answer[cnt] = arr[i];
				cnt++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
