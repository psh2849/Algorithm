package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ11780 {
	
	static int n, m;
	static long[][] dist;
	static int[][] next;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new long[n + 1][n + 1];
		next = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				next[i][j] = -1;
				if(i != j) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[s][d] = Math.min(dist[s][d], c);
			next[s][d] = s;
		}
		
		pro();
		print();
	}
	
	static void pro() {
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[k][j];
					}
				}
			}
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(next[i][j] == -1) {
					sb.append("0\n");
				} else {
					Stack<Integer> stack = new Stack<>();
					int prev = j;
					stack.push(prev);
					
					while(i != next[i][prev]) {
						prev = next[i][prev];
						stack.push(prev);
					}
					
					sb.append(stack.size() + 1 + " ");
					sb.append(i + " ");
					while(!stack.isEmpty()) {
						sb.append(stack.pop() + " ");
					}
					sb.append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
