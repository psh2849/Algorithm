package graph;

import java.util.*;
import java.io.*;

public class BOJ12851 {
	static int n, k;
	static int[] time = new int[100001];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0);
			System.out.println(1);
		} else {
			pro();
		}
	}

	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		time[n] = 1;
		int min = 987654321;
		int count = 0;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			if(min < time[p]) {
				break;
			}
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				
				if(i == 0) next = p + 1;
				if(i == 1) next = p - 1;
				if(i == 2) next = p * 2;
				
				if(next >= 0 && next <= 100000) {
					if(next == k) {
						min = time[p];
						count++;
					}
					
					if(time[next] == 0 || time[next] == time[p] + 1) {
						queue.add(next);
						time[next] = time[p] + 1;
					}
				}
			}
		}
		
		System.out.println(min);
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
