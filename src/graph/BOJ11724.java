package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {

	static int N, M, cnt = 0, ans = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean[] check;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		check = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
			check[x] = true;
			check[y] = true;
		}

		for (int i = 1; i <= N; i++) {
			dfs(i);
			if (cnt > 0) {
				ans++;
				cnt = 0;
			}
			if(!check[i]) {
				ans++;
			}
		}
		
		
	}

	static void dfs(int x) {
		visit[x] = true;

		for (int y : list[x]) {
			if (visit[y])
				continue;

			cnt++;
			dfs(y);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		System.out.println(ans);
	}
}
