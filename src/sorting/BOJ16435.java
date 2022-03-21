package sorting;

import java.util.*;
import java.io.*;

public class BOJ16435 {
	
	static int n, l;
	static int[] fruit;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		fruit = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruit);
		for(int i = 0; i < n; i++) {
			if(l >= fruit[i]) {
				l++;
			} else {
				System.out.println(l);
				return;
			}
		}
		
		System.out.println(l);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
