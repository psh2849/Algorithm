package implementation;

import java.util.*;
import java.io.*;

public class BOJ2460 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = 0;
		int max = 0;
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			
			people -= start;
			people += dest;
			
			max = Math.max(max, people);
		}
		
		System.out.println(max);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
