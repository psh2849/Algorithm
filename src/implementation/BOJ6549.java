package implementation;

import java.util.*;
import java.io.*;

public class BOJ6549 {

	static int n;
	static int[] height;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Stack<Integer> stack = new Stack<>();
			long max = 0;

			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;
			height = new int[n];
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int idx = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					max = Math.max(max, (long) height[idx] * width);
				}

				stack.push(i);
			}

			while (!stack.isEmpty()) {
				int idx = stack.pop();
				int width = stack.isEmpty() ? n : n - stack.peek() - 1;

				max = Math.max(max, (long) height[idx] * width);
			}

			System.out.println(max);

		}

	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
