/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/42889
 */
package programmers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PRO8 {

	static class Point implements Comparable<Point> {
		double value;
		int idx;

		public Point(double value, int idx) {
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (o.value == this.value) {
				return this.idx - o.idx;
			}
			return Double.compare(o.value, this.value);
		}
	}

	static double[] save;
	static ArrayList<Point> list = new ArrayList<>();
	static int cnt = 0;
	static int len;
	static int start = 0;

	static int[] solution(int N, int[] stages) {
		Arrays.sort(stages);
		int[] answer = new int[N];

		len = stages.length;

		for (int i = 1; i <= N; i++) {
			for (int j = start; j < stages.length; j++) {
				if (stages[j] > i)
					break;

				cnt++;
				start++;
			}
			if (cnt == 0) {
				list.add(new Point(0, i));
				continue;
			}
			list.add(new Point(cnt / (double) len, i));
			len -= cnt;
			cnt = 0;
		}

		Collections.sort(list);

		for (int i = 0; i < N; i++) {
			answer[i] = list.get(i).idx;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		solution(5, stages);
	}

}
