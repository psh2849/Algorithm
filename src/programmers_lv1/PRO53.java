/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */

package programmers_lv1;

import java.util.*;

public class PRO53 {

	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<>();

	public int solution(int[] cards) {
		int max = -1;

		visit = new boolean[cards.length];

		for (int i = 0; i < cards.length; i++) {
			int index = i;
			int count = 0;

			while (!visit[index]) {
				visit[index] = true;
				count++;
				index = cards[index] - 1;
			}

			list.add(count);
		}
	
		if (list.size() == 1) {
			return 0;
		}

		Collections.sort(list);

		max = list.get(list.size() - 1) * list.get(list.size() - 2);
		return max;

	}
}
