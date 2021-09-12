package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ5430 {

	static int T;
	static String function;
	static String str;
	static ArrayDeque<Integer> list = new ArrayDeque<>();
	static int N;
	static StringBuilder sb = new StringBuilder();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			list = new ArrayDeque<Integer>();

			function = br.readLine();
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "[],");

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			AC();
			
		}

		System.out.println(sb);

	}

	static void AC() {
		boolean isRight = true;
		for (char func : function.toCharArray()) {
			if (func == 'R') {
				isRight = !isRight;
				continue;
			}

			if (isRight) {
				if (list.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if (list.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		
		print(isRight);
	}
	
	static void print(boolean isRight) {
		sb.append('[');

		if (list.size() > 0) {
			if (isRight) {
				sb.append(list.pollFirst());

				while (!list.isEmpty()) {
					sb.append(',').append(list.pollFirst());
				}
			} else {
				sb.append(list.pollLast());
				while (!list.isEmpty()) {
					sb.append(',').append(list.pollLast());
				}
			}
		}

		sb.append(']' + "\n");
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
