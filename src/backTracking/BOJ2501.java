package backTracking;

import java.util.*;
import java.io.*;

public class BOJ2501 {
	
	static int n, k;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		pro();
	}
	
	static void pro() {
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				cnt++;
				if(cnt == k) {
					System.out.println(i);
					return;
				}
			}
		}
		
		System.out.println(0);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
