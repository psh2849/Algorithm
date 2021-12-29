/*
 * https://programmers.co.kr/learn/courses/30/lessons/87946
 */

package programmers_lv2;

public class PRO50 {
	static boolean[] visit;
	static int max = 0;

	static int solution(int k, int[][] dungeons) {
		int[][] output = new int[dungeons.length][2];
		visit = new boolean[dungeons.length];
		dfs(k, output, dungeons, 0);
		
		return max;
	}

	static void dfs(int k, int[][] output, int[][] dungeons, int depth) {
		if (depth == dungeons.length) {
			pro(output, k);
		}

		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				output[depth] = dungeons[i];
				dfs(k, output, dungeons, depth + 1);
				visit[i] = false;
			}
		}
	}

	static void pro(int[][] output, int k) {
		int temp = 0;

		for (int i = 0; i < output.length; i++) {
			if (output[i][0] <= k) {
				k -= output[i][1];
				temp++;
			}
		}
		max = Math.max(max, temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

		solution(k, dungeons);
	}

}
