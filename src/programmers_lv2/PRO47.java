/*
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */

package programmers_lv2;

import java.util.ArrayList;

public class PRO47 {
	static char[] prior = { '+', '-', '*' };
	static boolean[] visit = new boolean[3];
	static ArrayList<Long> list = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static long answer;
	static long solution(String expression) {
		answer = 0;

		String str = "";
		char[] arr = expression.toCharArray();
		for (char ch : arr) {
			if (ch >= '0' && ch <= '9') {
				str += ch;
			} else {
				list.add(Long.parseLong(str));
				str = "";
				op.add(ch);
			}
		}
		list.add(Long.parseLong(str));
		dfs(0, new char[3]);
		
		return answer;
	}

	static void dfs(int count, char[] p) {
		if (count == 3) {
			ArrayList<Long> nums = new ArrayList<>(list);
			ArrayList<Character> ops = new ArrayList<>(op);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < ops.size(); j++) {
					if (p[i] == ops.get(j)) {
						Long result = calc(nums.remove(j), nums.remove(j), p[i]);
						nums.add(j, result);
						ops.remove(j);
						j--;
					}
				}
			}
			
			answer = Math.max(answer, Math.abs(nums.get(0)));
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!visit[i]) {
				visit[i] = true;
				p[count] = prior[i];
				dfs(count + 1, p);
				visit[i] = false;
			}
		}
	}

	static Long calc(Long num1, Long num2, char op) {
		if (op == '-') {
			return num1 - num2;
		} else if (op == '+') {
			return num1 + num2;
		} else if (op == '*') {
			return num1 * num2;
		}
		
		return 0L;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("100-200*300-500+20");
	}

}
