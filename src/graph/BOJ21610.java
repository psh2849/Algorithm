package graph;

import java.util.*;
import java.io.*;

public class BOJ21610 {

	static class Air {
		int x;
		int y;

		public Air(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] map;
	static int[][] cloud;
	static boolean[][] visit;
	static ArrayList<Air> list = new ArrayList<>();
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cloud = new int[m][2];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			cloud[i][0] = a;
			cloud[i][1] = b;
		}

		list.add(new Air(n - 1, 0));
		list.add(new Air(n - 1, 1));
		list.add(new Air(n - 2, 0));
		list.add(new Air(n - 2, 1));

		for (int i = 0; i < m; i++) {
			visit = new boolean[n][n];
			int d = cloud[i][0];
			int s = cloud[i][1];

			move(d, s);
			add();
			remove();
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}

	static void move(int d, int s) {
		for (Air air : list) {
			int nx = (air.x + n + dx[d] * s % n) % n;
			int ny = (air.y + n + dy[d] * s % n) % n;

			visit[nx][ny] = true;
			map[nx][ny]++;
			air.x = nx;
			air.y = ny;
		}
	}

	static void add() {
		for (Air air : list) {
			int nx = -1, ny = -1, cnt = 0;
			for (int i = 2; i <= 8; i += 2) {
				nx = air.x + dx[i];
				ny = air.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(map[nx][ny] > 0) {
					cnt++;
				}
			}
			
			map[air.x][air.y] += cnt; 
		}
		
		list.clear();
	}
	
	static void remove() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) { 
				if(!visit[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					list.add(new Air(i, j));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
