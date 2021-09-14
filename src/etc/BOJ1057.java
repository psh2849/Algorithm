package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1057 {

	static int N;
	static int[] arr;
	static int j, h;
	static int cnt = 0;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		j = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		pro();
		System.out.println(cnt);
	}

	static void pro() {
		while (true) {
			cnt++;
			for (int i = 1; i <= N; i += 2) {
				if ((i == j && j + 1 == h) || i == h && h + 1 == j) {
					return;
				}
			}

			int r = j % 2;
			j = j / 2 + r;
			int r2 = h % 2;
			h = h / 2 + r2;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
