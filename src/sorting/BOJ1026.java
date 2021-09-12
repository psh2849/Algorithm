package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
	static int N, S = 0;
	static ArrayList<Integer> A = new ArrayList<>();
	static ArrayList<Integer> B = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			A.add(num);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			B.add(num);
		}
	}
	
	static void pro() {
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B);
		
		for(int i = 0; i < N; i++) {
			S += A.get(i) * B.get(i);
		}
		
		sb.append(S);
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}
}
