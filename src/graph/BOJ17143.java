package graph;

import java.util.*;
import java.io.*;

public class BOJ17143 {

	static class Shark {
		int x;
		int y;
		int speed;
		int direct;
		int weight;

		public Shark(int x, int y, int speed, int direct, int weight) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.direct = direct;
			this.weight = weight;
		}
	}

	static int r, c, m, fisher = 0, answer, nx, ny;
	static ArrayList<Shark> shark = new ArrayList<>();
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[r + 1][c + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			shark.add(new Shark(r, c, s, d, z));
			map[r][c] = z;
		}

		pro();
	}

	static void pro() {
		for (int i = 1; i <= c; i++) {
			moveFisher(i);
			moveShark();
		}
		
		System.out.println(answer);
	}

	static void moveFisher(int y) {
		for (int x = 1; x <= r; x++) {
			if (map[x][y] != 0) {
				for (int i = 0; i < shark.size(); i++) {
					if (shark.get(i).x == x && shark.get(i).y == y) {
						answer += shark.get(i).weight;
						map[x][y] = 0;
						shark.remove(i);
						return;
					}
				}
			}
		}
	}

	static void moveShark() {
		int[][] copy = new int[r + 1][c + 1];
		Queue<Integer> removeQueue = new LinkedList<>();

		for (int i = 0; i < shark.size(); i++) {
			Shark s = shark.get(i);
			map[s.x][s.y] = 0;

			for (int j = 0; j < s.speed; j++) {
				if (s.direct == 0 && s.x == 1) {
					s.direct = 1;
				} else if (s.direct == 1 && s.x == r) {
					s.direct = 0;
				} else if (s.direct == 2 && s.y == c) {
					s.direct = 3;
				} else if (s.direct == 3 && s.y == 1) {
					s.direct = 2;
				}

				s.x += dx[s.direct];
				s.y += dy[s.direct];
			}

			if (copy[s.x][s.y] == 0) {
				copy[s.x][s.y] = s.weight;
			} else if (copy[s.x][s.y] < s.weight) {
				removeQueue.add(copy[s.x][s.y]);
				copy[s.x][s.y] = s.weight;
			} else {
				removeQueue.add(s.weight);
			}
		}

		while (!removeQueue.isEmpty()) {
			int num = removeQueue.poll();

			for (int i = 0; i < shark.size(); i++) {
				if(shark.get(i).weight == num) {
					shark.remove(i);
				}
			}
		}
		
		map = copy;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
