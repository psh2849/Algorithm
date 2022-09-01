package graph;

import java.util.*;

public class BOJ9655 {

	static class Point {
		int count;
		int who;
		
		public Point(int count, int who) {
			this.count = count;
			this.who = who;
		}
	}

	static int n;

	static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		pro();

	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] check = new boolean[n];
		queue.add(new Point(n - 1, 1));
		check[n-1] = true;
		
		if(n >= 3) {
			queue.add(new Point(n - 3, 1));
			check[n-3] = true;
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
		
			if(p.count == 0) {
				if(p.who % 2 == 0) {
					System.out.println("CY");
				} else {
					System.out.println("SK");
				}
				
				return;
			}
			
			if(p.count - 1 >= 0 && !check[p.count - 1] ) {
				queue.add(new Point(p.count - 1, p.who + 1));
				check[p.count - 1] = true;
			}
			
			if(p.count - 3 >= 0 && !check[p.count - 3]) {
				queue.add(new Point(p.count - 3, p.who + 1));
				check[p.count - 3] = true;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
