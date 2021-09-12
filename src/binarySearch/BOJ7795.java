/*
 * ÀÌºÐ Å½»ö(¹éÁØ 7795¹ø. ¸ÔÀ» °ÍÀÎ°¡ ¸ÔÈú °ÍÀÎ°¡.)
 */
package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
	static int T;
	static int a, b;
	static int[] num1, num2;
	static StringBuilder sb = new StringBuilder();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			num1 = new int[a + 1];
			num2 = new int[b + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= a; i++) {
				num1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= b; i++) {
				num2[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(num1);
			Arrays.sort(num2);

			pro();
		}

	}

	static void pro() {
		int ans = 0;
		
		for(int i = 1; i <= a; i++) {
			ans += lower_bound(num2, 1, b, num1[i]);
			System.out.println(ans);
		}
	}
	
	static int lower_bound(int[] B, int L, int R, int num) {
		// TODO Auto-generated method stub
		int result = L -1;
		
		while(L <= R) {
			int mid = (L + R) / 2;
			if(B[mid] < num) {
				result = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
	
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
