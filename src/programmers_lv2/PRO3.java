/*
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
package programmers_lv2;

public class PRO3 {
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visit;
	static int cnt = 1;

	static int[] solution(int M, int N, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && picture[i][j] != 0) {
					numberOfArea++;
					visit[i][j] = true;
					int count = dfs(M, N, i, j, picture);
					cnt = 1;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		System.out.println(answer[0] + " " + answer[1]);
		return answer;
	}

	static int dfs(int M, int N, int x, int y, int[][] map) {
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= M || dy >= N)
				continue;
			if (visit[dx][dy])
				continue;
			if (map[dx][dy] != map[x][y])
				continue;

			visit[dx][dy] = true;
			cnt++;

			dfs(M, N, dx, dy, map);
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		solution(6, 4, picture);
	}

}
