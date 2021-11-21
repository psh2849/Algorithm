package graph;

import java.util.*;
import java.io.*;

public class BOJ14890 {

	static int n, l;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (check(i, 0, 0)) {
				answer++;
			}

			if (check(0, i, 1)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	static boolean check(int x, int y, int d) {
		boolean[] visit = new boolean[n];
		int[] height = new int[n];

		for (int i = 0; i < n; i++) {
			if (d == 0) {
				height[i] = map[x][y + i];
			} else {
				height[i] = map[x + i][y];
			}
		}

		for (int i = 0; i < n - 1; i++) {
			if (height[i] == height[i + 1]) {
				continue;
			}

			if (Math.abs(height[i] - height[i + 1]) > 1) {
				return false;
			}

			if (height[i] - 1 == height[i + 1]) {
				for (int j = i + 1; j <= i + l; j++) {
					if (j >= n || height[i + 1] != height[j] || visit[j])
						return false;
					visit[j] = true;
				}
			} else if (height[i] + 1 == height[i + 1]) {
				for (int j = i; j > i - l; j--) {
					if (j < 0 || height[i] != height[j] || visit[j])
						return false;
					visit[j] = true;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
