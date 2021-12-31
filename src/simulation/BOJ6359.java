package simulation;

import java.util.*;
import java.io.*;

public class BOJ6359 {

	static int t;
	static boolean[] door;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			door = new boolean[n + 1];
			for(int i = 1; i <= n; i++) {
				for(int j = i; j <= n; j+=i) {
					door[j] = !door[j];
				}
			}
			
			int count = 0;
			for(int i = 1; i <= n; i++) {
				if(door[i]) {
					count++;
				}
			}
			
			System.out.println(count);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
