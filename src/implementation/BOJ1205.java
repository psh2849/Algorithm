package implementation;

import java.util.*;
import java.io.*;

public class BOJ1205 {

	static int n, p, score, count = 0, same = 0;
	static Stack<Integer> stack = new Stack<>();
	static int[] arr;
	static boolean isBool = false;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		count = p;
		
		if (n == 0 && n <= p) {
			System.out.println(1);
			return;
		}

		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			arr[i] = num;
		}

		for (int i = n - 1; i >= 0; i--) {
			stack.add(arr[i]);
		}

		while (!stack.isEmpty()) {
			int num = stack.pop();

			if (num < score) {
				break;
			} else if(num == score){
				same++;
			} else {
				count--;
			}
		}
		
		if(count == 0 || p - count + same + 1 > p) {
			System.out.println(-1);
		} else {
			System.out.println(p - count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
