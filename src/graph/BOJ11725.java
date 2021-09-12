/*
 * 11725 트리의 부모 찾기(트리 문제)
 */
package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11725 {
	
	static int N;
	static int[] parent;
	static ArrayList<Integer>[] adj;
	
	static void input() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		adj = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for(int i = 1; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			adj[x].add(y);
			adj[y].add(x);
		}
	}
	
	static void pro() {
		dfs(1,-1);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	static void dfs(int x, int par) {
		for(int y: adj[x]) {
			if(y == par) continue;
			parent[y] = x;
			dfs(y, x);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
