package graph;

import java.util.*;
import java.io.*;

public class BOJ10216 {
	static int t, n;
	static int[][] map;
	static boolean[] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][3];
			visit = new boolean[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				map[i][0] = a;
				map[i][1] = b;
				map[i][2] = value;
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if(!visit[i]) {
					pro(i);
					cnt++;
				}
			}
			
			sb.append(cnt);
			System.out.println(cnt);
		}
	}

	static void pro(int k) {
		visit[k] = true;
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				double len = Math.sqrt(Math.pow(map[k][0] - map[i][0], 2) + Math.pow(map[k][1] - map[i][1], 2));
				if(len <= map[k][2] + map[i][2]) {
					pro(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
