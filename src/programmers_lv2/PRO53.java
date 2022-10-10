package programmers_lv2;

import java.util.*;

public class PRO53 {

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		boolean flag = true;
		for (int i = 0; i < discount.length; i++) {
			int range = i + 10;

			if (range > discount.length) {
				range = discount.length;
			}

			for (int j = i; j < range; j++) {
				if (map.containsKey(discount[j])) {
					map.put(discount[j], map.get(discount[j]) - 1);
				}
			}

			for (String key : map.keySet()) {
				if (map.get(key) > 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				answer++;
			}
			flag = true;
			for (int j = 0; j < want.length; j++) {
				map.put(want[j], number[j]);
			}
		}

		return answer;
	}

}
