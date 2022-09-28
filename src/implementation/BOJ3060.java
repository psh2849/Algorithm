package implementation;

import java.util.*;
import java.io.*;

public class BOJ3060 {

	static int t, n;
	static long[] pig;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			pig = new long[6];
			
			long answer = 0;
			int day = 1;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				pig[i] = Integer.parseInt(st.nextToken());
				answer += pig[i];
			}
			
			while(answer <= n) {
				answer *= 4;
				day++;
			}
			
			System.out.println(day);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
