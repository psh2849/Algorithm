package graph;

import java.util.*;
import java.io.*;

public class BOJ1507 {
	static int n;
	static int[][] map, arr;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = map[i][j];
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j || i == k || j == k)
						continue;

					if (map[i][j] > map[i][k] + map[k][j]) {
						System.out.println("-1");
						return;
					}

					if (map[i][j] == map[i][k] + map[k][j]) {
						arr[i][j] = 100000000;
					}
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] != 100000000) {
					sum += arr[i][j];
				}
			}
		}

		System.out.println(sum / 2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
