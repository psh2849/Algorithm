package implementation;

import java.util.*;
import java.io.*;

public class BOJ21921 {
	
	static int n, x;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int right = 0;
		int sum = 0;
		int max = 0;
		int count = 1;
		for(int i = 0; i < n; i++) {
			while(right - i < x && right < n) {
				sum += arr[right];
				right++;
			}
			
			if(max == sum) {
				count++;
			}
			if(sum > max) {
				max = sum;
				count = 1;
			}
			
			sum -= arr[i];
		}
		
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
