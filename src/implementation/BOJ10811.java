package implementation;

import java.io.*;
import java.util.*;

public class BOJ10811 {
	
	static int n, m;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int s = start;
			int e = end;
			
			for(int j = start; j <= (start + end) / 2; j++) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				
				s++;
				e--;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
