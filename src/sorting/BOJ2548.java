package sorting;

import java.util.*;
import java.io.*;

public class BOJ2548 {

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
		Arrays.sort(arr);
		int answer = pro();
		System.out.println(answer);
	}
	
	static int pro() {
		if(arr.length == 1) {
			return arr[0];
		}
		
		if(arr.length % 2 == 0) {
			return arr[arr.length / 2 - 1];
		} else {
			return arr[arr.length / 2];
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
