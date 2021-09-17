/*
 * 1068 Ʈ��(2)
 */
package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1068 {

	static int N;
	static ArrayList<Integer>[] child;
	static int erased;
	static int[] leaf;
	static int root;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		leaf = new int[N];
		child = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			child[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N; i++) {
			int par = sc.nextInt();
			if(par == -1) {
				root = i;
				continue;
			}
			child[par].add(i);
		}
		erased = sc.nextInt();

	}
	
	static void pro() {
		for(int i = 0; i < N; i++) {
			if(child[i].contains(erased)) {
				child[i].remove(child[i].indexOf(erased));
			}
		}
		
		if(root != erased) {
			dfs(root, -1);
		}

		System.out.println(leaf[root]);
	}
	
	static void dfs(int x, int par) {
		if(child[x].isEmpty()) {
			leaf[x]++;
		}
		
		for(int y : child[x]) {
			dfs(y, x);
			leaf[x] += leaf[y];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
