package sorting;

import java.util.*;
import java.io.*;

public class BOJ2910 {
	
	static class Point {
		int id;
		int num;
		int count;
		
		public Point(int id, int num, int count) {
			this.id = id;
			this.num = num;
			this.count = count;
		}
	}
	
	static HashMap<Integer, Point> map = new HashMap<>();
	static ArrayList<Point> list;
	static int n, m;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.putIfAbsent(num, new Point(i, num, 0));
			
			Point p = map.get(num);
			p.count++;
			map.put(num, p);
		}
		
		list = new ArrayList<>(map.values());
		
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.count == o2.count) {
					return Integer.compare(o1.id, o2.id);
				} else {
					return Integer.compare(o2.count, o1.count);
				}
			}
		});
		
		for(Point p : list) {
			for(int i = 0; i < p.count; i++) {
				System.out.print(p.num + " ");
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
