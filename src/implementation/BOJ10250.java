package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {

	static int T;
	static int H, W, N;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		int ans;
		int ans2;
		int num = N % H;
		int num2 = N / H + 1;
		if(num == 0) {
			ans = H * 100;
			ans2 = N / H;
		} else {
			ans = num * 100;
			ans2 = num2;
		}
			
		int result = ans + ans2;
		System.out.println(result);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			input();
			pro();
		}
	}

}
