package implementation;

import java.util.*;
import java.io.*;

public class BOJ10431 {

	static int t, n;
	static int[] arr = new int[21];
	static int[] arr2 = new int[21];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < 20; i++) {
				int idx = -1;
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i] < arr[j]) {
						idx = j;
					}
				}

				if (idx != -1) {
					int temp = arr[i];
					for (int j = i; j > idx; j--) {
						arr[j] = arr[j - 1];
						count++;
					}
					arr[idx] = temp;
				}

			}

			System.out.println(n + " " + count);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
