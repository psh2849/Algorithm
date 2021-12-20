package etc;

import java.util.*;
import java.io.*;

public class BOJ10211 {

	static int n, t;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			pro();
		}

	}

	static void pro() {
		int max = -1000001;
		
		for(int i = 0; i < n; i++) {
			int answer = 0;
			for(int j = i; j < n; j++) {
				answer += arr[j];
				if(max < answer) {
					max = answer;
				}
			}
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
