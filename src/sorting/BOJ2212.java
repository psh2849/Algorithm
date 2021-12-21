package sorting;

import java.util.*;
import java.io.*;

public class BOJ2212 {
	
	static int n, k, answer;
	static int[] arr;
	static Integer[] distance;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		distance = new Integer[n - 1];
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n - 1; i++) {
			distance[i] = arr[i + 1] - arr[i];
		}
	
		Arrays.sort(distance, Collections.reverseOrder());
		for(int i = k - 1; i < n - 1; i++) {
			answer += distance[i];
		}
		
		System.out.println(answer);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
