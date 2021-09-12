
/*
 * 3055. 탈출 BFS (최단 거리 구하기) (4~5)
 */
package shortestPath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ3055 {

	static int N, M;
	static String[] a;
	static int[][] water_dist;
	static int[][] animal_dist;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		a = new String[N];
		visit = new boolean[N][M];
		water_dist = new int[N][M];
		animal_dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			a[i] = sc.next();
		}
	}

	static void water_bfs() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				water_dist[i][j] = -1;
				visit[i][j] = false;

				if (a[i].charAt(j) == '*') {
					queue.add(i);
					queue.add(j);
					visit[i][j] = true;
					water_dist[i][j] = 0;
				}
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (a[nx].charAt(ny) != '.')
					continue;
				if (visit[nx][ny])
					continue;

				queue.add(nx);
				queue.add(ny);
				visit[nx][ny] = true;
				water_dist[nx][ny] = water_dist[x][y] + 1;
			}
		}

	}

	static void animal_bfs() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				animal_dist[i][j] = -1;
				visit[i][j] = false;

				if (a[i].charAt(j) == 'S') {
					visit[i][j] = true;
					animal_dist[i][j] = 0;
					queue.add(i);
					queue.add(j);
				}
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visit[nx][ny]) continue;
				if(a[nx].charAt(ny) != 'D' && a[nx].charAt(ny) != '.') continue;
				if(animal_dist[x][y] + 1 >= water_dist[nx][ny] && water_dist[nx][ny] != -1) continue;
				
				animal_dist[nx][ny] = animal_dist[x][y] + 1;
				queue.add(nx);
				queue.add(ny);
				visit[nx][ny] = true;
			}
		}
	}

	static void pro() {
		water_bfs();

		animal_bfs();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				// System.out.print(animal_dist[i][j] + " ");
				if(a[i].charAt(j) == 'D') {
					if(animal_dist[i][j] == -1) System.out.println("KAKTUS");
					else System.out.println(animal_dist[i][j]);
				}
			}
			// System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
