/*
 * 11066 파일 합치기
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11066 {

	static int N;
	static int[] num;
	static int[][] Dy;
	static ArrayList<Integer>[] con;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		num = new int[N + 1];
		con = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			con[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			con[x].add(y);
			con[y].add(x);
		}

	}

	static void pro() {
		Dy = new int[N + 1][2];

		dfs(1, -1);
		
		System.out.println(Math.max(Dy[1][0], Dy[1][1]));
	}

	static void dfs(int node, int parent) {
		Dy[node][0] = 0;
		Dy[node][1] = num[node];
		
		for(int child : con[node]) {
			if(child == parent) continue;
			dfs(child,node);
			Dy[node][0] += Math.max(Dy[child][0], Dy[child][1]);
			Dy[node][1] += Dy[child][0];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
		
	}

}
