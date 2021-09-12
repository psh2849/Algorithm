/*
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class PRO25 {

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] dist;
	static boolean[][] visit;
	static String[][] map;

	static int[] solution(String[][] places) {
		int[] answer = new int[5];
		map = new String[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String[] str = places[i][j].split("");
				for (int k = 0; k < 5; k++) {
					map[j][k] = str[k];
				}
			}
			int ans = 1;
			for (int j = 0; j < 5; j++) {
				for (int z = 0; z < 5; z++) {
					if (map[j][z].equals("P")) {
						ans = Math.min(ans, pro(j, z));
					}
				}
			}
			
			answer[i] = ans;
			System.out.println(answer[i]);
		}

		return answer;
	}

	static int pro(int x, int y) {
		visit = new boolean[5][5];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0));
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.cnt >= 2) {
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				int count = p.cnt;
				
				if(dx < 0 || dy < 0 || dx >= 5 || dy >= 5) continue;
				if(visit[dx][dy]) continue;
				visit[dx][dy] = true;

				if(map[dx][dy].equals("O")) {
					queue.add(new Point(dx, dy, count + 1));
				} else if(map[dx][dy].equals("P")) {
					
					if(count <= 2) {
						return 0;
					}
				}
			}
		}
		
		return 1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

		solution(places);
	}

}
