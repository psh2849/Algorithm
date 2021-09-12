package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
	static int R, C, width;
	static char[][] map;
	static int answer = 0;
	static int[] dir = { -1, 0 , 1};

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		width = C;

		for (int s = 0; s < R; s++) {
			dfs(s, 0);
		}
		
		System.out.println(answer);
	}

	static boolean dfs(int x, int y) {
		if (y == width - 1) {
			answer++;
			return true;
		} else {
			for (int i = 0; i < 3; i++) {
				int dx = x + dir[i];
				int dy = y + 1;

				if (dx < 0 || dy < 0 || dx >= R || dy >= C)
					continue;
				if(map[dx][dy] == 'x') continue;
				
				map[dx][dy] = 'x';
				
				if(dfs(dx, dy)) {
					return true;
				} 
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
