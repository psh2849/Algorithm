/*
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO3 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean[] dist;
	static int cnt;

	static int solution(int n, int[][] results) {
		dist = new boolean[n + 1];
		visit = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < results.length; i++) {
			// list[results[i][0]].add(results[i][1]);
			list[results[i][1]].add(results[i][0]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					dist[i] = bfs(i, j, n);
					if (!dist[i]) {
						if(bfs(j, i, n)) {
							dist[i] = true;
							continue;
						}
						break;
					}
				}
			}
			if (dist[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	static boolean bfs(int start, int dest, int n) {
		visit = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int p = queue.poll();
			if (p == dest) {
				return true;
			}
			for (int edge : list[p]) {
				if (visit[edge])
					continue;
				visit[edge] = true;
				queue.add(edge);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		solution(5, results);
	}

}
