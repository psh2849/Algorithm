package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int K, num, direction;
	static int arr[][] = new int[4][8];
	static int sum = 0;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			num = Integer.parseInt(st.nextToken());
			direction = Integer.parseInt(st.nextToken());
			pro(num - 1, direction);
		}

		for (int i = 0; i < 4; i++) {
			sum += arr[i][0] * (1 << i);
		}
	}

	static void pro(int num, int dir) {
		leftPossible(num - 1, -dir);
		rightPossible(num + 1, -dir);
		rotate(num, dir);
	}

	static void leftPossible(int num, int dir) {
		if (num < 0)
			return;

		if (arr[num][2] != arr[num + 1][6]) {
			leftPossible(num - 1, -dir);
			rotate(num, dir);
		}
	}

	static void rightPossible(int num, int dir) {
		if (num > 3)
			return;

		if (arr[num][6] != arr[num - 1][2]) {
			rightPossible(num + 1, -dir);
			rotate(num, dir);
		}
	}

	static void rotate(int num, int dir) {
		if (dir == 1) {
			int temp = arr[num][7];
			for (int i = 7; i > 0; i--) {
				arr[num][i] = arr[num][i - 1];
			}
			arr[num][0] = temp;
		} 
		else if (dir == -1) {
			int temp = arr[num][0];
			for (int i = 0; i < 7; i++) {
				arr[num][i] = arr[num][i + 1];
			}
			arr[num][7] = temp;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		System.out.println(sum);
	}

}
