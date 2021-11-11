package graph;

import java.util.*;
import java.io.*;

public class BOJ17472 {
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] parent;
	static int n, m, island, answer, cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] nx = { 0, 0, 1, -1 };
	static int[] ny = { 1, -1, 0, 0 };
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					island++;
					bfs(i, j);
				}
			}
		}
		
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					makeBridge(new Node(i,j), map[i][j]);
				}
			}
		}
	
		parent = new int[island + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		kruskal();
		
		if(answer == 0 || cnt != island - 1) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
		}
	}

	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		visit[x][y] = true;
		map[x][y] = island;
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = p.x + nx[i];
				int dy = p.y + ny[i];
				
				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (visit[dx][dy])
					continue;
				if(map[dx][dy] == 1) {
					queue.add(new Node(dx, dy));
					map[dx][dy] = island;
					visit[dx][dy] = true;
				}
			}
		}
	}

	static void makeBridge(Node p, int idx) {
		int len = 0;
		int dx = p.x;
		int dy = p.y;
		
		for (int i = 0; i < 4; i++) {
			while (true) {
				dx = dx + nx[i];
				dy = dy + ny[i];

				if (dx >= 0 && dy >= 0 && dx < n && dy < m) {
					if (map[dx][dy] == idx) {
						dx = p.x;
						dy = p.y;
						len = 0;
						break;
					} else if (map[dx][dy] == 0) {
						len++;
					} else {
						if (len > 1) {
							pq.add(new Point(idx, map[dx][dy], len));
						}
						len = 0;
						dx = p.x;
						dy = p.y;
						break;
					}
				} else {
					dx = p.x;
					dy = p.y;
					len = 0;
					break;
				}
			}
		}
	}

	static void kruskal() {
		int size = pq.size();
		for(int i = 0; i < size; i++) {
			Point p = pq.poll();
			int a = find(p.x);
			int b = find(p.y);
			
			if(a == b) continue;
			union(p.x, p.y);
			answer += p.value;
			cnt++;
		}
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		} else {
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
