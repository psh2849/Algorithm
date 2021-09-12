package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {

	static int areaMin = Integer.MAX_VALUE;
	static int N, total;
	static int[] people;
	static int[][] map;
	static boolean[][] copyMap;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		pro();
	}

	static void pro() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 >= N)
							continue;
						if (y + d2 >= N || y - d1 < 0)
							continue;

						calc(x, y, d1, d2);
					}
				}
			}
		}

		System.out.println(areaMin);
	}

	static void calc(int x, int y, int d1, int d2) {
		copyMap = new boolean[N][N];

		for (int i = 0; i <= d1; i++) {
			copyMap[x + i][y - i] = true;
			copyMap[x + d2 + i][y + d2 - i] = true;
		}

		for (int i = 0; i <= d2; i++) {
			copyMap[x + i][y + i] = true;
			copyMap[x + d1 + i][y - d1 + i] = true;
		}

		people = new int[5];

		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (copyMap[i][j])
					break;
				people[0] += map[i][j];
			}
		}

		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j > y; j--) {
				if (copyMap[i][j])
					break;
				people[1] += map[i][j];
			}
		}

		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if (copyMap[i][j])
					break;
				people[2] += map[i][j];
			}
		}

		for (int i = x + d2 + 1; i < N; i++) {
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if (copyMap[i][j])
					break;
				people[3] += map[i][j];
			}
		}

		people[4] = total - (people[0] + people[1] + people[2] + people[3]);
		Arrays.sort(people);
		areaMin = Math.min(areaMin, people[4] - people[0]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}
}
