package graph;

import java.util.*;
import java.io.*;

public class BOJ14248 {

	static int n, s;
	static int[] map;
	static int[] dir = { 1, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		map = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		s = Integer.parseInt(br.readLine()) - 1;

		pro();
	}

	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n];
		int answer = 1;
		queue.add(s);

		while (!queue.isEmpty()) {
			int point = queue.poll();
			
			for(int i = 0; i < 2; i++) {
				int d = (dir[i] * map[point]);
				int now = point + d;
				
				if(now < 0 || now >= n) continue;
				if(!visit[now]) {
					visit[now] =true;
					answer++;
					queue.add(now);
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
