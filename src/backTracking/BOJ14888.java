/*
 * 14888. ���� Ž��(������ �����ֱ�)
 */
package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
	static StringBuilder sb = new StringBuilder();
	static int N, max, min;
	static int[] nums, operators, order;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[N + 1];
		operators = new int[5];
		order = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

	static int calculator() {
		int value = nums[1];
		for (int i = 1; i <= N - 1; i++) {
			if (order[i] == 1) {
				value = value + nums[i + 1];
			}
			if (order[i] == 2) {
				value = value - nums[i + 1];
			}
			if (order[i] == 3) {
				value = value * nums[i + 1];
			}
			if (order[i] == 4) {
				value = value / nums[i + 1];
			}
		}

		return value;
	}

	static void rec_func(int k) {
		if (k == N) {
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for (int cand = 1; cand <= 4; cand++) {
				if (operators[cand] >= 1) {
					operators[cand]--;
					order[k] = cand;
					rec_func(k + 1);
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();

		rec_func(1);
	
		sb.append(max).append("\n").append(min).toString();
		System.out.println(sb.toString());
	}

}
