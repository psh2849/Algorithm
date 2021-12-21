package sorting;

import java.util.*;
import java.io.*;

public class BOJ2693 {
	
	static int n;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		while(n --> 0) {
			arr = new int[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
