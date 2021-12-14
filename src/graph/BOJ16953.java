package graph;

import java.util.*;
import java.io.*;

public class BOJ16953 {

	static class Point {
		long num;
		int idx;

		public Point(long num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}

	static int n, m;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pro();
	}
	
	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, 0));
		int answer = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			// System.out.println(p.num);
			if(p.num == m) {
				answer = Math.min(answer, p.idx);
			} 
			
			long mul = p.num * 2;
			long add = p.num * 10 + 1;
		
			if(mul <= m) {
				queue.add(new Point(mul, p.idx + 1));
			}
			
			if(add <= m) {
				queue.add(new Point(add, p.idx + 1));	
			}
		}
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer + 1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
