package graph;

import java.util.*;
import java.io.*;

public class BOJ16235 {

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	static int n, m, k, year = 0;
	static int[][] map, treeFood;
	static LinkedList<Tree> list = new LinkedList<>();
	static Queue<Tree> dead = new LinkedList<>();
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		treeFood = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = 5;
				treeFood[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			list.add(new Tree(x, y, age));
		}

		pro();
		System.out.println(list.size());
	}

	static void pro() {
		while (true) {
			if (year == k)
				return;
			// Collections.sort(list);
			spring();
			summer();
			autumn();
			winter();
			
			year++;
		}
	}

	static void spring() {
		Iterator<Tree> iter = list.iterator();
		while (iter.hasNext()) {
			Tree tree = iter.next();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
		
			if (map[x][y] - age < 0) {
				dead.add(tree);
				iter.remove();
			} else {
				map[x][y] -= age;
				tree.age++;
			}
		}
	}

	static void summer() {
		while (!dead.isEmpty()) {
			Tree tree = dead.poll();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;

			map[x][y] += age / 2;
		}
	}

	static void autumn() {
		LinkedList<Tree> baby = new LinkedList<>();

		for (Tree tree : list) {
			int x = tree.x;
			int y = tree.y;

			if (tree.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 1 || ny < 1 || nx > n || ny > n)
						continue;
					baby.add(new Tree(nx, ny, 1));
				}
			}
		}

		list.addAll(0, baby);
	}

	static void winter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] += treeFood[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
