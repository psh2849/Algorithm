package implementation;

import java.util.*;
import java.io.*;

public class BOJ2012 {
	
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
		pro();
	}
	
	static void pro() {
		int rank = 1;
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Math.abs(arr[i] - rank);
			rank++;
		}
		
		System.out.println(sum);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
