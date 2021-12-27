package implementation;

import java.util.*;
import java.io.*;

public class BOJ2846 {

	static int n;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int a = arr[0], b = 0;
		for (int i = 0; i < n - 1; i++) {
			
			if (arr[i] < arr[i + 1]) {
				b = arr[i + 1];
			}
			if(arr[i] >= arr[i + 1] || i == n - 2){
				max = Math.max(b - a, max);
				a = arr[i + 1];
			}
		}
		
		if(max == Integer.MAX_VALUE || max <= 0) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
