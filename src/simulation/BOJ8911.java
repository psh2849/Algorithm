package simulation;

import java.util.*;
import java.io.*;

public class BOJ8911 {

	static int t;
	static String com;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int minX = 0, minY = 0, maxX = 0, maxY = 0;
			int d = 0;
			int nowX = 0, nowY = 0;

			com = br.readLine();

			for (int i = 0; i < com.length(); i++) {
				if (com.charAt(i) == 'F') {
					nowX = nowX + dir[d][0];
					nowY = nowY + dir[d][1];
				} else if (com.charAt(i) == 'B') {
					nowX = nowX - dir[d][0];
					nowY = nowY - dir[d][1];
				} else if (com.charAt(i) == 'L') {
					if(d == 0) d = 3;
					else d--;
				} else {
					if(d == 3) d = 0;
					else d++;
				}
				
				minX = Math.min(minX, nowX);
				minY = Math.min(minY, nowY);
				maxX = Math.max(maxX, nowX);
				maxY = Math.max(maxY, nowY);
			}
			
			System.out.println((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
