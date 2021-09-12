package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {

	static int N, B, C;
	static long[] student;
	static long cnt = 0;
	static long ans = 0;
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		student = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		for (int i = 0; i < N; i++) {
			student[i] -= B;
			ans++;
		}

		for (int i = 0; i < N; i++) {
			if (student[i] > 0) {
				long res = student[i] / C;
				long res2 = student[i] % C;
				if (res2 != 0)
					res++;

				ans += res;
			}
		}
		
		sb.append(ans);
		System.out.println(ans);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}
}
