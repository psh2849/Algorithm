package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {

	static int N, K, cnt = 0;
	static int[] durability;
	static boolean[] robot;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		robot = new boolean[N];
		durability = new int[2 * N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		while (isOk()) {
			int temp = durability[durability.length - 1];
			for (int i = durability.length - 1; i > 0; i--) {
				durability[i] = durability[i - 1];
			}
			durability[0] = temp;

			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;

			robot[N - 1] = false;
			for (int i = N - 1; i > 0; i--) {
				if (!robot[i] && durability[i] > 0 && robot[i - 1]) {
					robot[i] = true;
					robot[i - 1] = false;
					durability[i]--;
				}
			}

			if (durability[0] != 0) {
				robot[0] = true;
				durability[0]--;
			}

			cnt++;
		}
		
		System.out.println(cnt);
	}

	static boolean isOk() {
		int count = 0;

		for (int i = 0; i < durability.length; i++) {
			if (durability[i] == 0) {
				count++;
			}
		}

		if (count >= K) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
