/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
package programmers_lv2;

public class PRO4 {

	static int solution(int[] numbers, int target) {
		int answer = 0;

		answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);

		System.out.println(answer);
		return answer;
	}

	static int dfs(int[] numbers, int target, int sum, int idx) {
		if (idx == numbers.length) {
			if (target == sum) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int ans = 0;
		ans += dfs(numbers, target, sum + numbers[idx], idx + 1);
		ans += dfs(numbers, target, sum - numbers[idx], idx + 1);
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		solution(numbers, target);
	}

}
