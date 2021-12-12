package shortestPath;

import java.io.*;
import java.util.*;

public class BOJ17182 {
	
	static int n, m;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visit;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		pro();
		visit[m] = true;
		dfs(m, 0, 0);
		
		System.out.println(answer);
	}
	
	static void pro() {
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) continue;
					
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}
	
	static void dfs(int start, int count, int sum) {
		if(count == n - 1) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, count + 1, sum + map[start][i]);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
