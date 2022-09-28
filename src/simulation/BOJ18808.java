package simulation;

import java.util.*;
import java.io.*;

public class BOJ18808 {

	static int n, m, k, answer;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[r][c];
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int z = 0; z < c; z++) {
					sticker[j][z] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < 4; j++) {
				if (attach(sticker)) {
					break;
				}

				sticker = rotate(sticker);
			}
		}
		
		System.out.println(answer);
	}

	static boolean attach(int[][] sticker) {
		for (int i = 0; i < n - sticker.length + 1; i++) {
			for (int j = 0; j < m - sticker[0].length + 1; j++) {
				if (check(sticker, i, j)) {
					success(sticker, i, j);
					return true;
				}
			}
		}

		return false;
	}

	static boolean check(int[][] sticker, int row, int col) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j] == 1 && map[row + i][col + j] == 1)
					return false;
			}
		}

		return true;
	}

	static void success(int[][] sticker, int row, int col) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j] == 1) {
					map[row + i][col + j] = 1;
					answer++;
				}
			}
		}
	}

	static int[][] rotate(int[][] sticker) {
		int[][] newSticker = new int[sticker[0].length][sticker.length];

		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				newSticker[j][sticker.length - i - 1] = sticker[i][j];
			}
		}

		return newSticker;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
