package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11441 {
	
	static int N, M;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i =0;i < M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pro(s, d);
		}
	}
	
	static void pro(int s, int d) {
		int sum = 0;
		for(int i = s - 1; i < d; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}
}
