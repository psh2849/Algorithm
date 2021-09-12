/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/68935
 */
package programmers_lv1;

import java.util.ArrayList;

public class PRO12 {
	static ArrayList<Integer> list = new ArrayList<>();

	static int solution(int n) {
		int answer = 0;

		pro(n);
		int cnt = 1;
		int len = list.size();
		for (int i = len - 1; i >= 0; i--) {
			answer += list.get(i) * cnt;
			cnt = 3 * cnt;
		}
	
		return answer;
	}

	static void pro(int n) {
		while (n >= 1) {
			int num = n % 3;
			n = n / 3;
			list.add(num);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(45);
	}

}
