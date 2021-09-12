package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1292 {

	static int[] arr = new int[10000000];
	static int cnt = 1;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < i; j++) {
				arr[cnt] = i;
				cnt++;
			}
		}

		int sum = 0;
		for (int i = A; i <= B; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
