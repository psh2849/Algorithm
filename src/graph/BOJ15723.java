package graph;

import java.util.*;
import java.io.*;

public class BOJ15723 {

	static int n, m, num1, num2;
	static int[] parent;
	static boolean flag = false;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		parent = new int[26];
		for(int i = 0; i < 26; i++) {
			parent[i] = -1;
		}
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			num1 = str.charAt(0) - 'a';
			num2 = str.charAt(str.length() - 1) - 'a';
			
			parent[num1] = num2;
			
		}
		
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			
			int start = str.charAt(0) - 'a';
			int dest = str.charAt(5) - 'a';
			
			while(parent[start] != dest) {
				start = parent[start];
				
				if(start == -1) {
					System.out.println("F");
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				System.out.println("T");
			} else {
				flag = false;
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
