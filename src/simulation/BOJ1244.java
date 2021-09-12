package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

	static int N, s_num;
	static int[] switchStatus;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		switchStatus = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			switchStatus[i] = Integer.parseInt(st.nextToken());
		}

		s_num = Integer.parseInt(br.readLine());
		for (int i = 0; i < s_num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pro(a, b);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(switchStatus[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

	static void pro(int a, int b) {
		if (a == 1) {
			boy(b);
		} else if (a == 2) {
			girl(b);
		}
	}

	static void boy(int b) {
		for (int i = b; i <= N; i++) {
			if (i % b == 0) {
				switchStatus[i] = switchStatus[i] == 0 ? 1 : 0;
			}
		}
	}

	static void girl(int b) {
		int left = b - 1;
		int right = b + 1;

		if (switchStatus[b] == 1) {
			switchStatus[b] = 0;
		} else {
			switchStatus[b] = 1;
		}
		while (left > 0 && right <= N) {
			if (switchStatus[left] == switchStatus[right]) {
				if (switchStatus[left] == 1) {
					switchStatus[left] = 0;
					switchStatus[right] = 0;
				} else {
					switchStatus[left] = 1;
					switchStatus[right] = 1;
				}
			} else {
				break;
			}
			

			left--;
			right++;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();

	}

}
