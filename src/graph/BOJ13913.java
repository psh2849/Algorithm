package graph;

import java.io.*;
import java.util.*;

public class BOJ13913 {
	static int n, k;
	static int[] parent = new int[100001];
	static int[] time = new int[100001];
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		pro();
		showParent();
	}
	
	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		time[n] = 1;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();

			if(p == k) {
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int res;
				
				if(i == 0) res = p - 1;
				else if(i == 1) res = p  + 1;
				else res = p * 2;
				
				if(res > 100000 || res < 0) continue;
				
				if(time[res] == 0) {
					time[res] = time[p] + 1;
					parent[res] = p;
					queue.add(res);
				}
			}
		}
	}
	
	static void showParent() {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		stack.push(k);
		int index = k;
		
		sb.append(time[k] - 1 + "\n");
		
		while(index != n) {
			stack.push(parent[index]);
			index = parent[index];
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb.toString());
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
