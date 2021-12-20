package simulation;

import java.util.*;
import java.io.*;

public class BOJ1547 {
	
	static int m;
	static int[] cup;
	
	static void input() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		m = Integer.parseInt(br.readLine());
		
		int owner = 1;
		for(int i = 0; i < m; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == owner) {
				owner = b;
			} 
			else if(b == owner){
				owner = a;
			}
		}
		
		System.out.println(owner);	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
