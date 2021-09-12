/*
 * 2252. 줄세우기- 위상정렬(3)
 */
package topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2252 {
	
	static int N, M;
	static ArrayList<Integer>[] adj;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] indeg;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		adj = new ArrayList[N+1];
		indeg = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
		
			adj[x].add(y);
			indeg[y]++;
		}
		
		pro();
	}
	
	static void pro() {
		for(int i = 1; i <= N; i++) {
			if(indeg[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			
			for(int y : adj[x]) {
				indeg[y]--;
				if(indeg[y] == 0) {
					queue.add(y);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
