/*
 * https://programmers.co.kr/learn/courses/30/lessons/70130
 */
package programmers_lv3;

import java.util.HashMap;

public class PRO30 {

	static int solution(int[] a) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>(a.length);
		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) == null) {
				map.put(a[i], 1);
			} else {
				map.replace(a[i], map.get(a[i]) + 1);
			}
		}

		for (int key : map.keySet()) {
			if (map.get(key) * 2 <= answer)
				continue;
			int star = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if ((a[i] == key || a[i + 1] == key) && (a[i] != a[i + 1])) {
					star += 2;
					i++;
				}
			}
			answer = Math.max(answer, star);
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
