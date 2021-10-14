/*
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 */

package programmers_lv2;

public class PRO42 {

	static int[][] map;

	static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int cnt = 1;
		map = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = cnt++;
			}
		}

		int min = 0;
		int len = 0;
		while (len < queries.length) {
			min = rotate(queries[len][0], queries[len][1], queries[len][2], queries[len][3]);
			answer[len] = min;
			len++;
		}

		return answer;
	}

	static int rotate(int x1, int y1, int x2, int y2) {
		int temp = map[x1][y1];
		int min = temp;

		for (int i = x1; i < x2; i++) {
			map[i][y1] = map[i + 1][y1];
			min = Math.min(min, map[i][y1]);
		}

		for (int i = y1; i < y2; i++) {
			map[x2][i] = map[x2][i + 1];
			min = Math.min(min, map[x2][i]);
		}

		for (int i = x2; i > x1; i--) {
			map[i][y2] = map[i - 1][y2];
			min = Math.min(min, map[i][y2]);
		}

		for (int i = y2; i > y1; i--) {
			map[x1][i] = map[x1][i - 1];
			min = Math.min(min, map[x1][i]);
		}
		
		map[x1][y1 + 1] = temp;
		
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		solution(6, 6, queries);
	}

}
