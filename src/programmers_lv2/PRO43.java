/*
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
package programmers_lv2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PRO43 {
	static int solution(String[][] relation) {
		int answer = 0;
		int rowsize = relation.length;
		int colsize = relation[0].length;
		List<Integer> candidates = new LinkedList<>();

		for (int i = 1; i < 1 << colsize; i++) {
			if (check(relation, rowsize, colsize, i) == true) {
				candidates.add(i);
			}
		}

		while (candidates.size() != 0) {
			int n = candidates.remove(0);
			++answer;

			for (Iterator<Integer> it = candidates.iterator(); it.hasNext();) {
				int c = it.next();
				if ((n & c) == n) {
					it.remove();
				}
			}
		}

		return answer;
	}

	static boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		for (int a = 0; a < rowsize - 1; a++) {
			for (int b = a + 1; b < rowsize; b++) {
				boolean isSame = true;
				for (int k = 0; k < colsize; k++) {
					if ((subset & 1 << k) == 0)
						continue;
					if (relation[a][k].equals(relation[b][k]) == false) {
						isSame = false;
						break;
					}
				}
				if (isSame)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		solution(relation);
	}

}
