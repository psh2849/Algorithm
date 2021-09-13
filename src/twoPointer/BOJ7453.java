package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {

	static int N;
	static int[] A, B, C, D, AB, CD;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		AB = new int[N * N];
		CD = new int[N * N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());

		}

		int AB_idx = 0;
		int CD_idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[AB_idx] = A[i] + B[j];
				CD[CD_idx] = C[i] + D[j];
				AB_idx++;
				CD_idx++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		long ans = pro();
		System.out.println(ans);
	}

	static long pro() {
		int left = 0;
		int right = CD.length - 1;
		long cnt = 0;
		
		while(left < N * N && right >= 0) {
			int AB_value = AB[left];
			int CD_value = CD[right];
			
			int sum = AB_value + CD_value;
			
			if(sum == 0) {
				long left_cnt = 0;
				long right_cnt = 0;
				while(left < N * N && AB[left] == AB_value) {
					left++;
					left_cnt++;
				}
				
				while(right >= 0 && CD[right] == CD_value) {
					right--;
					right_cnt++;
				}
				
				cnt += left_cnt * right_cnt;
			} else if(sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
