/*
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */
package programmers_lv3;

public class PRO13 {

	static boolean solution(int[][] key, int[][] lock) {
		int offset = key.length - 1;

		for (int i = 0; i < offset + lock.length; i++) {
			for (int j = 0; j < offset + lock.length; j++) {
				for (int rot = 0; rot < 4; rot++) {
					int[][] arr = new int[58][58];
					for (int z = 0; z < lock.length; z++) {
						for (int z2 = 0; z2 < lock.length; z2++) {
							arr[offset + z][offset + z2] = lock[z][z2];
						}
					}

					match(arr, key, rot, i, j);
					if (check(arr, offset, lock.length)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	static void match(int[][] arr, int[][] key, int rot, int r, int c) {
		int n = key.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rot == 0) {
					arr[r + i][c + j] += key[i][j];
				} else if (rot == 1) {
					arr[r + i][c + j] += key[j][n - 1 - i];
				} else if (rot == 2) {
					arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
				} else {
					arr[r + i][c + j] += key[n - 1 - j][i];
				}
			}
		}
	}

	static boolean check(int[][] arr, int offset, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[offset + i][offset + j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
