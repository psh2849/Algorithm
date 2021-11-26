package implementation;

import java.util.*;
import java.io.*;

public class BOJ1934 {

	static int n;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			int ans = pro(a, b);
			int result = a * b / ans;
			System.out.println(result);
		}
	}

	
	static int pro(int a, int b) {
		if(a == 0) return b;
		else return pro(b % a, a);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
