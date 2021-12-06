package backTracking;

import java.util.*;
import java.io.*;

public class BOJ12100 {

	static int n;
	static int[][] map;
	static int max = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro(0);
		System.out.println(max);
	}

	static void pro(int count) {
		if (count == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return;
		}
		
		int copy[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			copy[i] = map[i].clone();
		}
		
		for (int i = 0; i < 4; i++) {
			move(i);
			pro(count + 1);
			for (int j = 0; j < n; j++) {
				map[j] = copy[j].clone();
			}
		}
	}

	static void move(int dir) {
		if (dir == 0) {
			for (int i = 0; i < n; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < n; j++) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) {
							map[index - 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index++;
						}
					}
				}
			}
		} else if (dir == 1) {
			for (int i = 0; i < n; i++) {
				int index = n - 1;
				int block = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
		} else if (dir == 2) {
			for (int i = 0; i < n; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						if (block == map[i][j]) {
							map[i][index - 1] = block * 2;
							map[i][j] = 0;
							block = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
		} else if (dir == 3) {
			for (int i = 0; i < n; i++) {
				int index = n - 1;
				int block = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						if (block == map[i][j]) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
