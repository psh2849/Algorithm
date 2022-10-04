package programmers_lv2;

import java.util.*;

public class BOJ51 {

	public int solution(int[] queue1, int[] queue2) {
		int answer = -2;
		long sum = 0;
		long leftSum = 0;
		long rightSum = 0;
		int count = 0;
		int lcount = 0, rcount = 0;

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i = 0; i < queue1.length; i++) {
			q1.add(queue1[i]);
			sum += queue1[i];
			leftSum += queue1[i];
		}

		for (int i = 0; i < queue2.length; i++) {
			q2.add(queue2[i]);
			sum += queue2[i];
			rightSum += queue2[i];
		}

		if (sum % 2 != 0) {
			return -1;
		}

		while (true) {
			if (lcount > queue1.length * 2 && rcount > queue1.length * 2) {
				answer = -1;
				return answer;
			}

			if (leftSum == rightSum) {
				return count;
			} else if (leftSum > rightSum) {
				int num = q1.poll();
				q2.add(num);
				leftSum -= num;
				rightSum += num;
				lcount++;
			} else {
				int num = q2.poll();
				q1.add(num);
				leftSum += num;
				rightSum -= num;
				rcount++;
			}

			count++;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
