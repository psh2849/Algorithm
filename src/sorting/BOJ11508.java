package sorting;

import java.util.*;
import java.io.*;

public class BOJ11508 {
	
	static int n;
	static Integer[] product;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		product = new Integer[n];
		for(int i = 0; i < n; i++) {
			product[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(product, Collections.reverseOrder());
		
		int cost = 0;
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0) continue;
			cost += product[i - 1];
		}
		
		System.out.println(cost);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
