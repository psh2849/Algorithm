/*
 * https://programmers.co.kr/learn/courses/30/lessons/60061
 */
package programmers_lv3;

public class PRO33 {
	static int[][] map;
	static int save = -1;
	static boolean[][] pillar, beam;
	static final int PIL = 0, BM = 1, REMOVE = 0, ADD = 1;

	static int[][] solution(int n, int[][] build_frame) {
		int count = 0;
		pillar = new boolean[n + 3][n + 3];
		beam = new boolean[n + 3][n + 3];

		for (int[] frame : build_frame) {
			int x = frame[0] + 1;
			int y = frame[1] + 1;
			if (frame[2] == PIL) {
				if (frame[3] == ADD && checkPillar(x, y)) {
					pillar[x][y] = true;
					count++;
				}

				if (frame[3] == REMOVE && deleteThing(x, y, PIL, n)) {
					pillar[x][y] = false;
					count--;
				}
			} else if (frame[2] == BM) {
				if (frame[3] == ADD && checkBeam(x, y)) {
					beam[x][y] = true;
					count++;
				}

				if (frame[3] == REMOVE && deleteThing(x, y, BM, n)) {
					beam[x][y] = false;
					count--;
				}
			}
		}

		int[][] answer = new int[count][3];
		int cnt = 0;
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (pillar[i][j]) {
					answer[cnt][0] = i - 1;
					answer[cnt][1] = j - 1;
					answer[cnt][2] = PIL;
					cnt++;
				}
				if (beam[i][j]) {
					answer[cnt][0] = i - 1;
					answer[cnt][1] = j - 1;
					answer[cnt][2] = BM;
					cnt++;
				}
			}
		}
		
		return answer;
	}

	static boolean checkPillar(int x, int y) {
		return y == 1 || beam[x][y] || pillar[x][y - 1] || beam[x - 1][y];
	}

	static boolean checkBeam(int x, int y) {
		return pillar[x + 1][y - 1] || pillar[x][y - 1] || (beam[x - 1][y] && beam[x + 1][y]);
	}

	static boolean deleteThing(int x, int y, int d, int n) {
		boolean save = true;

		if (d == PIL) {
			pillar[x][y] = false;
		} else {
			beam[x][y] = false;
		}

		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (pillar[i][j] && !checkPillar(i, j)) {
					save = false;
					break;
				}
				if (beam[i][j] && !checkBeam(i, j)) {
					save = false;
					break;
				}
			}
			if (!save) {
				break;
			}
		}

		if (d == PIL) {
			pillar[x][y] = true;
		} else {
			beam[x][y] = true;
		}

		return save;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
//				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };

		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };

		solution(5, build_frame);
	}

}
