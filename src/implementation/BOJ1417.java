package implementation;

import java.util.*;
import java.io.*;

public class BOJ1417 {
	static int n;
	static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.add(num);		
		}
		
		int answer = 0;
		if(queue.isEmpty()) {
			System.out.println(0);
			return;
		}
		while(queue.peek() >= dasom) {
			int cand = queue.poll();
			dasom++;
			answer++;
			queue.add(cand - 1);
		}
		
		System.out.println(answer);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
