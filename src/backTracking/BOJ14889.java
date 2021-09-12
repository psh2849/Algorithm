/*
 * 14889 스타트와 링크
 */
package backTracking;

import java.util.Scanner;

public class BOJ14889 {

	static int N;
	static int[][] map;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	static void pro(int idx, int k) {
		if (k == N / 2) {
			diff();
		} else {
			for(int i = idx; i < N; i++) {
				visit[i] = true;
				pro(i + 1, k + 1);
				visit[i] = false;
			}
		}
	}

	static void diff() {
		int first_team = 0;
		int second_team = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visit[i] == true && visit[j] == true) {
					first_team += map[i][j];
					first_team += map[j][i];
				} 
				if(visit[i] == false && visit[j] == false) {
					second_team += map[i][j];
					second_team += map[j][i];
				}
			}
		}
		
		int ans = Math.abs(first_team - second_team);
	
		
		min = Math.min(ans, min);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(0,0);
		System.out.println(min);
	}

}
