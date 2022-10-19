package implementation;

import java.util.*;
import java.io.*;

public class BOJ15903 {
	
	static int n, m;
	static PriorityQueue<Long> queue = new PriorityQueue<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}
		
		long result = 0;
		while(m-->0) {
			long first = queue.poll();
			long second = queue.poll();

			result = (first + second);
			queue.add(result);
			queue.add(result);
		}
		
		long answer = 0;
		while(!queue.isEmpty()) {
			answer += queue.poll();
		}
		
		System.out.println(answer);
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
