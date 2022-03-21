package sorting;

import java.util.*;
import java.io.*;

public class BOJ1758 {

	static int n;
	static Integer[] rank;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		rank = new Integer[n];
		for(int i = 0; i < n; i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rank, Collections.reverseOrder());
		long answer = 0;
		for(int i = 0; i < n; i++) {
			int tip = rank[i] - i;
			if(tip < 0) continue;
			answer += tip;
		}
		
		System.out.println(answer);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
