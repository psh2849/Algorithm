/*
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 */
package programmers_lv2;

public class PRO19 {

	static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		String[] saveWords = new String[words.length];

		for (int i = 0; i < words.length; i++) {
			if (prevSpeakWord(words, i)) {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				return answer;
			}

			saveWords[i] = words[i];
		}
		
		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}

	static boolean prevSpeakWord(String words[], int idx) {
		if(idx == 0) {
			return false;
		}
		for (int i = 0; i < idx; i++) {
			if (words[i].equals(words[idx])) {
				return true;
			}
		}
		
		if (words[idx - 1].charAt(words[idx - 1].length() - 1) != words[idx].charAt(0)) {
			return true;
		}

		if (words[idx].length() < 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		solution(2, words);
	}

}
