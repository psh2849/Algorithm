/*
 * https://programmers.co.kr/learn/courses/30/lessons/86971?language=java
 */
package programmers_lv2;

import java.util.*;

public class PRO49 {
	static int min = Integer.MAX_VALUE;
	static List<Integer>[] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static int solution(int n, int[][] wires) {
		int answer = 101;
		map = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];

			map[a].add(b);
			map[b].add(a);
		}

		for (int[] wire : wires) {
			int num1 = pro(n, wire[0], wire[1]);
			int num2 = pro(n, wire[1], wire[0]);

			answer = Math.min(answer, Math.abs(num2 - num1));
		}
		System.out.println(answer);
		return answer;
	}

	static int pro(int n, int x, int y) {
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		int cnt = 0;
		visit[x] = true;

		while (!queue.isEmpty()) {
			int p = queue.poll();
			cnt++;
			for (int num : map[p]) {
				if (num != y && !visit[num]) {
					queue.add(num);
					visit[num] = true;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		solution(9, wires);
		int[][] wires2 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		solution(4, wires2);
	}

}
