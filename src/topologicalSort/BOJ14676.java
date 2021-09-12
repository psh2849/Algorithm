/*
 * 14676. 영우는 사기꾼?
 */
package topologicalSort;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ14676 {

	static int N, M, K;
	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static int[] satisfaction;
	static int[] cnt;
	static Scanner sc = new Scanner(System.in);

	static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		satisfaction = new int[N + 1];
		indegree = new int[N + 1];
		cnt = new int[N + 1];
		
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adj[x].add(y);
			indegree[y]++;
		}

	}

	static void pro() {
		boolean abnormal = false;
		
		for (int i = 0; i < K; i++) {
			int t = sc.nextInt();
			int x = sc.nextInt();
			if (t == 1) {
				if(satisfaction[x] < indegree[x]) {
					abnormal = true;
				} 
				cnt[x]++;
				
				if(cnt[x] == 1) {
					for(int j : adj[x]) {
						satisfaction[j]++;
					}
				}
				
			} else if (t == 2) {
				if(cnt[x] == 0) {
					abnormal = true;
				}
				
				cnt[x]--;
				if(cnt[x] == 0) {
					for(int j : adj[x]) {
						satisfaction[j]--;
					}
				}
			}
		}
		
		if(abnormal) {
			System.out.println("Lier!");
		} else {
			System.out.println("King-God-Emperor");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
