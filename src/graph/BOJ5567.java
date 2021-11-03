package graph;

import java.util.*;
import java.io.*;

public class BOJ5567 {
	static int[] parent;
	static int n, m, answer;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
		
		visit[1] = true;
		find(1, 0);
		
		for(int i = 2; i < visit.length; i++) {
			if(visit[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void find(int a, int cnt) {
		if(cnt >= 2) {
			return;
		}
		
		for(int i = 0; i < list[a].size(); i++) {
			int num = list[a].get(i);
			visit[num] = true;
			find(num, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
