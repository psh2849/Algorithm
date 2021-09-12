/*
 * 2178. 미로 탐색(BFS를 이용해서 최단거리를 구하는 방법(2))
 */
package shortestPath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

	static int N, M;
	static String a[];
	static boolean[][] visit;
	static int[][] dist;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		a = new String[N];
		visit = new boolean[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			a[i] = sc.next();
		}
	}

	static void bfs(int x, int y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = -1;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		queue.add(y);
		visit[x][y] = true;
		dist[x][y] = 1;

		while (!queue.isEmpty()) {
			x = queue.poll();
			y = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(a[nx].charAt(ny) == '0') continue;
				if(visit[nx][ny]) continue;
				
				queue.add(nx);
				queue.add(ny);
				visit[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
	}

	static void pro() {
		bfs(0, 0);

		System.out.println(dist[N-1][M-1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
