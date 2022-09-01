package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ11722 {

	static int n;
	static int[] arr;
	static int[] save;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		save = new int[n];
		
		StringTokenizer st  =new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		save[0] = 1;
		for(int i = 0; i < n; i++) {
			save[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					save[i] = Math.max(save[j] + 1, save[i]);
				}
			}
			
			answer = Math.max(answer, save[i]);
		}
	
		System.out.println(answer);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
