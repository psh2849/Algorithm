/*
 * 4963.¼¶ÀÇ °³¼ö
 */
package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ4963 {
	static int W, H;
	static boolean[][] visit;
	static int[][] arr;
	static int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static ArrayList<Integer> count;
	static int land_count = 0;

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= H || dy >= W)
				continue;

			if (!visit[dx][dy] && arr[dx][dy] == 1) {
				dfs(dx, dy);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if (W == 0 && H == 0)
				break;

			visit = new boolean[H][W];
			arr = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visit[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						land_count++;
					}
				}
			}
			System.out.println(land_count);
			land_count = 0;
		}
	}
}
