/*
 * 4485. ≥Ïªˆ ø ¿ª ¿‘¿∫ æ÷∞° ¡©¥Ÿ¡ˆ?
 */
package shortestPath;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Information {
	int x;
	int y;
	int roopy;

	public Information(int x, int y, int roopy) {
		this.x = x;
		this.y = y;
		this.roopy = roopy;
	}
}

public class BOJ4485 {

	static int N = 1, cnt = 1;
	static int[][] arr;
	static int[][] dist;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
	static Scanner sc = new Scanner(System.in);

	static void input() {
		arr = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		pro(1, 1);
	}

	static void pro(int x, int y) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == 1 && j == 1)
					dist[i][j] = arr[i][j];
				else
					dist[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Information> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.roopy));
		pq.add(new Information(x, y, arr[0][0]));

		while (!pq.isEmpty()) {
			Information info = pq.poll();

			for (int i = 0; i < 4; i++) {
				int dx = info.x + dir[i][0];
				int dy = info.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx > N || dy > N)
					continue;
				
				if (dist[dx][dy] > arr[dx][dy] + dist[info.x][info.y]) {
					dist[dx][dy] = arr[dx][dy] + dist[info.x][info.y] ;
					pq.add(new Information(dx, dy, dist[dx][dy]));
				}
			}
		}
		
		System.out.println("Problem " + cnt + ": " + dist[N][N]);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (N != 0) {
			N = sc.nextInt();
			if (N == 0)
				return;
			input();
			cnt++;
		}
	}

}
