package simulation;

import java.util.*;
import java.io.*;
import java.io.*;

public class BOJ1063 {

	static int[][] map = new int[9][9];
	static int n, king_x, king_y, stone_x, stone_y;
	static int[] dx = { 0, 0, 1, -1, -1, -1, 1, 1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String king = st.nextToken();
		String stone = st.nextToken();
		n = Integer.parseInt(st.nextToken());

		king_x = 8 - (king.charAt(0) - 'A');
		king_y = king.charAt(1) - '0';
		map[9 - king_y][9 - king_x] = 1;
		
		stone_x = 8 - (stone.charAt(0) - 'A');
		stone_y = stone.charAt(1) - '0';
		map[9 - stone_y][9 - stone_x] = 2;
		
		int save_k_x = king_x;
		int save_k_y = king_y;
		int save_s_x = stone_x;
		int save_s_y = stone_y;
		
		king_x = 9 - save_k_y;
		king_y = 9 - save_k_x;
		stone_x = 9 - save_s_y;
		stone_y = 9 - save_s_x;

		for (int i = 0; i < n; i++) {
			String command = br.readLine();

			pro(command);
		}
		
		print();
	}
	
	static void print() {
		String k = "", s = "";
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (map[i][j] == 1) {
					k = (char) (j + 'A' - 1) + "" + (9 - i);
				}
				if (map[i][j] == 2) {
					s = (char) (j + 'A' - 1) + "" + (9 - i);
				}
			}
		}
		
		System.out.println(k);
		System.out.println(s);
	}

	static void pro(String command) {
		if (command.equals("R")) {
			move(0);
		} else if (command.equals("L")) {
			move(1);
		} else if (command.equals("B")) {
			move(2);
		} else if (command.equals("T")) {
			move(3);
		} else if (command.equals("RT")) {
			move(4);
		} else if (command.equals("LT")) {
			move(5);
		} else if (command.equals("RB")) {
			move(6);
		} else if (command.equals("LB")) {
			move(7);
		}
	}

	static void move(int dir) {
		int save_x = king_x;
		int save_y = king_y;

		int nx = king_x + dx[dir];
		int ny = king_y + dy[dir];
		
		if (nx <= 0 || ny <= 0 || nx > 8 || ny > 8)
			return;
		
		if (map[nx][ny] == 2) {
			stone_x = nx + dx[dir];
			stone_y = ny + dy[dir];
			
			if(stone_x <= 0 || stone_y <= 0 || stone_x > 8 || stone_y > 8) return;
			map[stone_x][stone_y] = 2;
		}

		map[nx][ny] = 1;
		map[save_x][save_y] = 0;
		king_x = nx;
		king_y = ny;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
