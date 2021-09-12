/*
 * 3584.가장 가까운 공통 조상
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ3584 {
	static int T, N, A, B;
	static int N1, N2;
	static int[] parent;
	static ArrayList<Integer>[] adj;
	static StringBuilder sb = new StringBuilder();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			adj = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				String temp[] = br.readLine().split(" ");
				A = Integer.parseInt(temp[0]);
				B = Integer.parseInt(temp[1]);
				parent[B] = A;
				adj[A].add(B);
			}

			String[] temp2 = br.readLine().split(" ");
			N1 = Integer.parseInt(temp2[0]);
			N2 = Integer.parseInt(temp2[1]);

			int n1_depth = get_depth(N1);
			int n2_depth = get_depth(N2);

			int ans = solve(N1, n1_depth, N2, n2_depth);
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

	static int solve(int a, int a_depth, int b, int b_depth) {
		if (a_depth > b_depth) {
			while (a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		} else if (a_depth < b_depth) {
			while (a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;

	}

	static int get_depth(int x) {
		int ret = 0;
		int cur = x;
		while (cur != 0) {
			ret++;
			cur = parent[cur];
		}

		return ret - 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
	}

}
