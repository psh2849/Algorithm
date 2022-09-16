package implementation;

import java.util.*;
import java.io.*;

public class BOJ3758 {

	static int t;
	static int n, k, id, m;
	static int[][] team;
	static int[] submit;
	static int[] score;
	static int[] time;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			id = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			team = new int[101][101];
			submit = new int[n + 1];
			score = new int[n + 1];
			time = new int[n + 1];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int tid = Integer.parseInt(st.nextToken());
				int number = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				if (team[tid][number] < s) {
					score[tid] -= team[tid][number];
					score[tid] += s;
					team[tid][number] = s;
				}
				submit[tid]++;
				time[tid] = i + 1;
			}

			int rank = 1;
			for (int i = 1; i <= n; i++) {
				if(i == id) continue;

				if(score[i] > score[id]) rank++;
				else if(score[i] == score[id]) {
					if(submit[i] < submit[id]) rank++;
					else if(submit[i] == submit[id]) {
						if(time[i] < time[id]) rank++;
					}
				}
			}
			
			System.out.println(rank);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
