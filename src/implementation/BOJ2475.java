package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2475 {
	
	static int[] arr;
	static int result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[5];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] *= arr[i];
			
			result += arr[i];
		}
		
		sb.append(result % 10);
		System.out.println(sb);
		
	}

}
