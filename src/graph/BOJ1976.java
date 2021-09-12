package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {

	static int N, M;
	static int[] parent;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					union(i, j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(start != find(num)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
