package implementation;

import java.util.*;
import java.io.*;

public class BOJ15685 {
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[][] map = new int[101][101];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list.add(d);
			for (int j = 0; j < g; j++) {
				for (int z = list.size() - 1; z >= 0; z--) {
					list.add((list.get(z) + 1) % 4);
				}
			}

			map[y][x] = 1;
			for (int dir : list) {
				x += dx[dir];
				y += dy[dir];

				map[y][x] = 1;
			}

			list.clear();
		}

		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
