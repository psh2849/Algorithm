package graph;

import java.util.*;
import java.io.*;

public class BOJ19236 {

	static class Fish {
		int x;
		int y;
		int num;
		int dir;
		int alive;

		public Fish(int x, int y, int num, int dir, int alive) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.alive = alive;
		}
	}

	static Fish[] fish;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map;
	static int shark_x, shark_y, shark_dir, shark_eat;
	static int ans = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[4][4];
		fish = new Fish[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = a;
				fish[a] = new Fish(i, j, a, b, 1);
			}
		}

		shark_x = 0;
		shark_y = 0;
		shark_dir = fish[map[0][0]].dir;
		shark_eat = map[0][0];
		fish[map[0][0]].alive = 0;
		map[0][0] = -1;

		dfs(shark_x, shark_y, shark_dir, shark_eat);
		
		System.out.println(ans);
	}

	static void dfs(int x, int y, int d, int sum) {
		ans = Math.max(ans, sum);

		int[][] tempMap = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
		}

		Fish[] tempFish = new Fish[fish.length];
		for (int i = 1; i <= 16; i++) {
			tempFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].num, fish[i].dir, fish[i].alive);
		}

		moveFish();

		for (int i = 1; i < 4; i++) {
			int nx = x + dx[d] * i;
			int ny = y + dy[d] * i;
			
			if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != 0) {
				int eatFish = map[nx][ny];
				int dir = fish[eatFish].dir;
				
				map[x][y] = 0;
				map[nx][ny] = -1;
				fish[eatFish].alive = 0;
				
				dfs(nx, ny, dir, sum + eatFish);
				
				fish[eatFish].alive = 1;
				map[x][y] = -1;
				map[nx][ny] = eatFish;
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			System.arraycopy(tempMap[i], 0, map[i], 0, map.length);
		}
		
		for(int i = 1; i <= 16; i++) {
			fish[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].num, tempFish[i].dir, tempFish[i].alive);
		}
	}

	static void moveFish() {
		for(int i = 1; i <= 16; i++) {
			if(fish[i].alive == 0) continue;
			
			int cnt = 0;
			int dir = fish[i].dir;
			int nx = 0, ny = 0;
			while(cnt < 8) {
				dir = dir % 8;
				fish[i].dir = dir;
				
				nx = fish[i].x + dx[dir];
				ny = fish[i].y + dy[dir];
				
				if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
					if(map[nx][ny] == 0) {
						map[fish[i].x][fish[i].y] = 0;
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					} else {
						int change = fish[map[nx][ny]].num;
						fish[change].x = fish[i].x;
						fish[change].y = fish[i].y;
						map[fish[change].x][fish[change].y] = change;
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				} else {
					cnt++;
					dir++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
