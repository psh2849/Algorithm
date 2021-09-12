package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1107 {
	static int N, M, min;
	static List<Integer> list = new ArrayList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
		}
	
		pro();
	}

	static void pro() {
		min = Math.abs(100 - N);

		for (int i = 0; i < 1000000; i++) {
			int len = check(i);

			if (len > 0) {
				min = Math.min(min, Math.abs(i - N) + len);
			}
		}

		System.out.println(min);
	}

	static int check(int num) {
		int length = 0;

		if (num == 0) {
			return list.contains(num) ? 0 : 1;
		}

		while (num > 0) {
			if (list.contains(num % 10)) {
				return 0;
			}

			length++;
			num /= 10;
		}

		return length;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
