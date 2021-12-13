package sorting;

import java.util.*;
import java.io.*;

public class BOJ2075 {
	
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
		}
		
		Collections.sort(list);
		sb.append(list.get(list.size() - n));
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
