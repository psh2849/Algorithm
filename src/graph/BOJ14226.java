package graph;

import java.util.*;
import java.io.*;

public class BOJ14226 {
	static class Copy {
		int clipboard;
		int screen;
		int time;
		
		public Copy(int clipboard, int screen, int time) {
			this.clipboard = clipboard;
			this.screen = screen;
			this.time = time;
		}
	}
	
	static int s;
	static boolean[][] visit = new boolean[2001][2001];
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
	
		pro();
	}
	
	static void pro() {
		Queue<Copy> queue = new LinkedList<>();
		queue.add(new Copy(0, 1, 0));
		visit[0][1] = true;
		
		while(!queue.isEmpty()) {
			Copy p = queue.poll();
			
			if(p.screen == s) {
				System.out.println(p.time);
				break;
			}
			
			queue.add(new Copy(p.screen, p.screen, p.time + 1));
			
			if(p.clipboard != 0 && p.clipboard + p.screen <= s && !visit[p.clipboard][p.screen + p.clipboard]) {
				queue.add(new Copy(p.clipboard, p.screen + p.clipboard, p.time + 1));
				visit[p.clipboard][p.screen + p.clipboard] = true;
			}
			
			if(p.screen >= 1 && !visit[p.clipboard][p.screen - 1]) {
				queue.add(new Copy(p.clipboard, p.screen - 1, p.time + 1));
				visit[p.clipboard][p.screen - 1] = true;
			}
		}	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
