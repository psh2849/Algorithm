package implementation;

import java.util.*;
import java.io.*;

public class BOJ2578 {
	
	static int[][] map = new int[5][5];
	static boolean[][] visit = new boolean[5][5];
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) { 
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 1;
		for(int i = 0; i < 5; i++) { 
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				count++;
				int num = Integer.parseInt(st.nextToken());
				
				boolean bingo = find(num);
				if(bingo) {
					System.out.println(count - 1);
					return;
				}
			}
		}
	}
	
	static boolean find(int num) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[i][j] == num) {
					visit[i][j] = true;
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(visit[i][j]) {
					cnt++;
				}
			}
			
			if(cnt == 5) {
				result++;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(visit[j][i]) {
					cnt++;
				}
			}
			
			if(cnt == 5) {
				result++;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(visit[i][i]) {
				cnt++;
			}
			
			if(cnt == 5) {
				result++;
			}
		}
		
		cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(visit[4-i][i]) {
				cnt++;
			}
			if(cnt == 5) {
				result++;
			}
		}
		
		
		if(result >= 3) {
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
