package etc;

import java.io.*;
import java.util.*;

public class BOJ1449 {

	static int N;
	static int L;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		pro();
	}

	static void pro() {
		double pos = arr[0] - 0.5 + L;
		int answer = 1;
		for (int i = 1; i < N; i++) {
			if(pos < (arr[i] + 0.5)) {
				pos = (arr[i] - 0.5 + L);
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
