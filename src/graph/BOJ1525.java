package graph;

import java.util.*;
import java.io.*;

public class BOJ1525 {

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static String str = "";
	static String answer = "123456780";
	static HashMap<String, Integer> map = new HashMap<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				str += num;
			}
		}
		
		map.put(str, 0);
		int answer = pro(str);
		System.out.println(answer);
	}

	static int pro(String str) {
		Queue<String> queue = new LinkedList<>();
		queue.add(str);
		
		while(!queue.isEmpty()) {
			String p = queue.poll();
			int time = map.get(p);
			int zero = p.indexOf('0');
			int dx = zero % 3;
			int dy = zero / 3;
			
			if(p.equals(answer)) {
				return time;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = dx + dir[i][0];
				int ny = dy + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx > 2 || ny > 2) continue;
				int newIndex = 3 * ny + nx;
				char ch = p.charAt(newIndex);
				String next = p.replace(ch, 'c');
				next = next.replace('0', ch);
				next = next.replace('c', '0');
				
				if(!map.containsKey(next)) {
					queue.add(next);
					map.put(next, time + 1);
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
