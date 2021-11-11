package implementation;

import java.util.*;
import java.io.*;

public class BOJ2490 {

	static int[][] map = new int[3][4];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					cnt++;
				}
			}

			if (cnt == 0) {
				System.out.println("E");
			} else if (cnt == 1) {
				System.out.println("A");
			} else if (cnt == 2) {
				System.out.println("B");
			} else if (cnt == 3) {
				System.out.println("C");
			} else {
				System.out.println("D");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
