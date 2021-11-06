package graph;

import java.util.*;
import java.io.*;

public class BOJ1058 {

	static int max = Integer.MIN_VALUE;
	static int n;
	static int[][] cost = new int[51][51];

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (str.charAt(j - 1) == 'Y') {
					cost[i][j] = 1;
				} else {
					cost[i][j] = 100000000;
				}
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (cost[i][j] == 1 || cost[i][j] == 2) {
					cnt++;
				}
			}

			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
