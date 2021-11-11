package implementation;

import java.util.*;
import java.io.*;

public class BOJ2455 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < 4; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sum -= a;
			sum += b;
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
