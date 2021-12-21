package sorting;

import java.util.*;
import java.io.*;

public class BOJ15688 {
	
	static int n;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i + "\n");
		}
		System.out.print(sb);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
