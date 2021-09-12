package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Point> direction = new LinkedList<>();
	static Deque<Point> snake = new ArrayDeque<>();
	static int N, K, L;
	static int snakeDir = 3;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		map[0][0] = -1;
		snake.offer(new Point(0, 0));

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x - 1][y - 1] = 1;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d;
			int x = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			if(str.equals("L")) {
				d = 0;
			} else {
				d = 1;
			}
			
			direction.add(new Point(x, d));
		}
		
		pro();
	}
	
	static void pro() {
		int time = 0;
		int X = direction.peek().x;
		int Y = direction.poll().y;
		while(true) {
			time++;
			
			int nx = snake.peekFirst().x + dx[snakeDir];
			int ny = snake.peekFirst().y + dy[snakeDir];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
			
			if(map[nx][ny] == -1) {
				break;
			}
			if(map[nx][ny] == 1) {
				map[nx][ny] = -1;
				snake.offerFirst(new Point(nx, ny));
			} else {
				map[nx][ny] = -1;
				snake.offerFirst(new Point(nx, ny));
				
				map[snake.peekLast().x][snake.pollLast().y] = 0;
			}
			
			if(time == X) {
				if(Y == 0) {
					snakeDir = (snakeDir+1) % 4;
				} else {
					snakeDir = (snakeDir+3) % 4;
				}
				
				if(!direction.isEmpty()) {
					X = direction.peek().x;
					Y = direction.poll().y;
				}
			}
		}
		
		System.out.println(time);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
