package union;

import java.util.*;
import java.io.*;

public class BOJ10775 {
	
	static int G, P, answer;
	static int[] parent;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		parent = new int[G + 1];
		for(int i = 0; i <= G; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int pass = find(g);

			if(pass == 0) {
				break;
			}
			
			answer++;
			union(pass, pass - 1);
		}
		
		// System.out.println(answer);
		
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[a] = b;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
