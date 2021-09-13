/*
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */
package programmers_lv2;

public class PRO28 {
	static int N, M;
	static char[][] map;

	static int solution(int m, int n, String[] board) {
		int answer = 0;
		N = m;
		M = n;
		map = new char[N][M];
		
		for(int i = 0; i < board.length; i++) {
			map[i] = board[i].toCharArray();
		}
		
		while(true) {
			boolean[][] visit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != '*') {
						checkBlock(i, j, visit);
					}
				}
			}
			
			int dropCnt = dropBlock(visit);
		
			if(dropCnt == 0) {
				return answer;
			}
			answer += dropCnt;
		}
	}

	static void checkBlock(int x, int y, boolean[][] visit) {
		int[] dx = {0, 0, 1, 1};
		int[] dy = {0, 1, 1, 0};
		boolean isPossible = true;
		
		for(int i = 1; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				isPossible = false;
				break;
			}
			if(map[nx][ny] != map[x][y]) {
				isPossible = false;
				break;
			}
			
		}

		if(!isPossible) {
			return;
		}
	
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visit[nx][ny] = true;
		}
	}
	
	static int dropBlock(boolean[][] visit) {
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(visit[j][i]) {
					cnt++;
					for(int z = j; z >= 0; z--) {
						if(z == 0) {
							map[z][i] = '*';
						} else {
							map[z][i] = map[z-1][i];
						}
					}
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		solution(4, 5, board);
	}

}
