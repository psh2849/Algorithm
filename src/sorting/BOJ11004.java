package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11004 {
	
	static int N, K;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(num);
		}
		
	}
	
	static void pro() {
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		sb.append(arr.get(K-1));
		
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}
}
