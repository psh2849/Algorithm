package implementation;

import java.util.*;
import java.io.*;

public class BOJ2477 {

	static int n;
	static int bx, by;
	static int maxBxIdx = -1, maxByIdx = -1;
	static int[] dist = new int[6];
	static int big_square, small_square;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			dist[i] = Integer.parseInt(st.nextToken());
			
			if(num == 1 || num == 2) {
				if(bx < dist[i]) {
					bx = dist[i];
					maxBxIdx = i;
				}
			}
			
			if(num == 3 || num == 4) {
				if(by < dist[i]) {
					by = dist[i];
					maxByIdx = i;
				}
			}
		}
		
		big_square = bx * by;
		small_square = dist[(maxBxIdx + 3) % 6] * dist[(maxByIdx + 3) % 6];
		System.out.println((big_square - small_square) * n);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
