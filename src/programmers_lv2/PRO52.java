package programmers_lv2;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */
import java.util.ArrayList;
import java.util.Collections;

public class PRO52 {

	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<>();

	public int solution(int[] cards) {

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

		return list.get(list.size() - 1) * list.get(list.size() - 2);
	}

}
