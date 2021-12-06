package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ11048 {
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new int[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro();
	}

	static void pro() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		int answer = map[n-1][m-1];
		dp[0][0] = map[0][0];
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			if(q[0] == n - 1 && q[1] == m - 1) {
				answer = Math.max(answer, dp[n - 1][m - 1]);
				continue;
			}
			
			for(int i = 0; i < 3; i++) {
				int nx = q[0] + dx[i];
				int ny = q[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(dp[q[0]][q[1]] + map[nx][ny] > dp[nx][ny]) {
					dp[nx][ny] = dp[q[0]][q[1]] + map[nx][ny];
					queue.add(new int[] {nx,ny});
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
