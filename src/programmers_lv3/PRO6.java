/*
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
package programmers_lv3;

public class PRO6 {
	static int answer;
	static boolean[] visit;

	static int solution(String begin, String target, String[] words) {
		answer = 51;
		visit = new boolean[words.length];
		dfs(begin, target, 0, words);
		
		return (answer == 51) ? 0 : answer;
	}

	static void dfs(String begin, String target, int count, String[] words) {
		if (begin.equals(target)) {
			answer = (answer > count) ? count : answer;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (!visit[i] && check(begin, words[i])) {
				visit[i] = true;
				dfs(words[i], target, count + 1, words);
				visit[i] = false;
			}
		}
	}

	static boolean check(String begin, String word) {
		int cnt = 0;

		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i)) {
				cnt++;
			}
		}

		return cnt == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		solution("hit", "cog", words);
	}

}
