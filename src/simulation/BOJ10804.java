package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10804 {
	static int[] arr = new int[21];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int i = 1; i <= 20; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			reverse(a, b);
		}
		
		for(int i = 1; i <= 20; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void reverse(int a, int b) {
		int mid = (a + b) / 2;
		int left = a;
		int right = b;
		
		while (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
