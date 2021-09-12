/*
 * 22252. 정보 상인 호석
 */
package graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ22252 {

	static int Q, K, sel, id;
	static String name;
	static HashMap<String, Integer> map = new HashMap<>();
	static PriorityQueue<Integer>[] queue;
	static int id_cnt = 0;
	static Scanner sc = new Scanner(System.in);

	static void input() {
		Q = sc.nextInt();
		queue = new PriorityQueue[100001];
	}

	static void pro() {
		long ans = 0;

		while (Q > 0) {
			Q--;
			sel = sc.nextInt();
			name = sc.next();
			id = getName();
			if (sel == 1) {
				K = sc.nextInt();

				for (int i = 1; i <= K; i++) {
					int cost = sc.nextInt();
					queue[id].add(cost);
				}
			} else {
				K = sc.nextInt();

				while (K > 0 && !queue[id].isEmpty()) {
					K--;
					ans += queue[id].poll();
				}
			}
		}

		System.out.println(ans);
	}

	static int getName() {
		if (!map.containsKey(name)) {
			map.put(name, ++id_cnt);

			queue[id_cnt] = new PriorityQueue<>(Comparator.reverseOrder());
		}

		return map.get(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
