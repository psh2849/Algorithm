package sorting;

import java.util.*;
import java.io.*;

public class BOJ9237 {
	
	static int n;
	static Integer[] plant;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		plant = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			plant[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(plant, Collections.reverseOrder());
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			plant[i] = plant[i] + i + 1;
			if(max < plant[i]) max = plant[i];
		}
		
		System.out.println(max + 1);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
