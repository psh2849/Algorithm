/*
 * 2667번 단지번호 붙이기(그래프 격자 문제)
 */

package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2667 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, group_cnt;
	static int[][] adj;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer> group;

	static void input() {
		N = sc.nextInt();

		adj = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				adj[i][j] = input.charAt(j) - '0';
			}
		}
	}

	static void dfs(int x, int y) {
		visit[x][y] = true;
		group_cnt++;
		
		for(int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(adj[nx][ny] == 0) continue;
			if(visit[nx][ny] == true) continue;
			
			dfs(nx, ny);
		}
	}

	static void pro() {
		group = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(!visit[i][j] && adj[i][j] == 1) {
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}
		
		Collections.sort(group);
		System.out.println(group.size());
		for(int cnt : group) {
			System.out.println(cnt);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
