package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {

	static int N;
	static long even, odd;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		if (N == 1 || N == 2) {
			System.out.println(1);
			return;
		}
		
		if(N == 3) {
			System.out.println(2);
			return;
		}
		
		even = 2;
		odd = 1;
		
		for(int i = 5; i <= N; i++) {
			Long temp = odd;
			odd = even;
			even = even + temp;		
		}
		
		sb.append(odd + even);
		
		System.out.println(sb);
	}

}
