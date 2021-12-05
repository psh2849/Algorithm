package etc;

import java.util.*;
import java.io.*;

public class BOJ18258 {

	static int n;
	static Deque<Integer> queue = new LinkedList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();

			if (str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				cnt++;
				queue.add(num);
			} else if (str.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.pollFirst() + "\n");
					cnt--;
				}
			} else if (str.equals("size")) {
				sb.append(cnt + "\n");
			} else if (str.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (str.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.peekFirst() + "\n");
				}
			} else if (str.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.peekLast() + "\n");
				}
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
