package simulation;

import java.util.*;
import java.io.*;

public class BOJ10709 {

	static int n, m;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			boolean isCloud = false;
			int idx = -1;
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'c') {
					isCloud = true;
					idx = j;
					System.out.print(0 + " ");
				} else {
					if (isCloud) {
						System.out.print(j - idx + " ");
					} else {
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}
