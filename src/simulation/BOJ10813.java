package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10813 {

	static int N, M;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
