/*
 * https://programmers.co.kr/learn/courses/30/lessons/12936
 */
package programmers_lv3;

class PRO17 {
	static long N;
	static int[] answer;
	static int idx;

	public int[] solution(int n, long k) {
		answer = new int[n];
		boolean[] chk = new boolean[n];
		N = n - 1;
		idx = 0;
		getNumber(n, k, chk, fac(n - 1));

		return answer;
	}

	private void getNumber(int n, long k, boolean[] chk, long fact) {
		if (idx == N) {
			for (int i = 0; i < chk.length; i++) {
				if (!chk[i]) {
					answer[idx] = i + 1;
					break;
				}

			}
			return;
		}
		long last = k % fact == 0 ? fact : k % fact;
		long first = k % fact == 0 ? k / fact : k / fact + 1;
		int cnt = 0;
		for (int i = 0; i < chk.length; i++) {
			if (!chk[i]) {
				cnt++;
				if (cnt == first) {
					answer[idx++] = i + 1;
					chk[i] = true;
					getNumber(n - 1, last, chk, fact / (n - 1));
				}
			}
		}
	}

	public long fac(int n) {
		long i = 1;
		for (int j = 2; j < n + 1; j++) {
			i *= j;
		}
		return i;
	}
}
