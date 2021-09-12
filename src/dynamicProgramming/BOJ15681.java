/*
 * 15681번 트리와 쿼리(dp 서브트리 (3))
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15681 {

	static int N, Q, R, T;
	static ArrayList<Integer>[] con;
	static int Dy[];
	static Scanner sc = new Scanner(System.in);
	
	static void input() {
		N = sc.nextInt();
		R = sc.nextInt();
		Q = sc.nextInt();
		
		con = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			con[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1; i++) {
			int x = sc.nextInt();
			int y=  sc.nextInt();
			
			con[x].add(y);
			con[y].add(x);
		}
	}
	
	static void dfs(int node, int parent) {
		Dy[node] = 1;
		
		for(int child : con[node]) {
			if(child == parent) continue;
			dfs(child, node);
			Dy[node] += Dy[child];
		}
	}
	static void pro() {
		Dy = new int[N + 1];
		
		dfs(R, -1);
		
		for(int i = 0; i < Q; i++) {
			T = sc.nextInt();
			System.out.println(Dy[T]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
