/*
 * https://programmers.co.kr/learn/courses/30/lessons/12950
 */
package programmers_lv1;

public class PRO44 {

	static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = { { 1 }, { 2 } };
		int[][] arr2 = { { 3 }, { 4 } };

		solution(arr1, arr2);
	}

}
