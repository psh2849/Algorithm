package etc;

import java.util.*;
import java.io.*;

public class BOJ1992 {

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		pro(0, 0, n);
		System.out.println(sb);
	}

	static void pro(int x, int y, int size) {
		if (possible(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}

		int newSize = size / 2;

		sb.append('(' - '49');
		
		pro(x, y, newSize);
		pro(x, y + newSize, newSize);
		pro(x + newSize, y, newSize);
		pro(x + newSize, y + newSize, newSize);
		
		sb.append(')');
	}

	static boolean possible(int x, int y, int size) {
		int value = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != value) {
					return false;
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
