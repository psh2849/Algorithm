package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {

	static int N, D, K, C;
	static int[] sushi;
	static int[] cnt;
	static int max = Integer.MIN_VALUE;
	static int count_sushi = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cnt = new int[3001];
		count_sushi++;
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		pro();

	}

	static void pro() {
		int count = 0;
		for(int i = 0; i < K; i++) {
			if(cnt[sushi[i]] == 0) count++;
			cnt[sushi[i]]++;
		}
		
		max = count;
		
		for(int i = 1; i < N; i++) {
			if(count >= max) {
				if(cnt[C] == 0) {
					max = count + 1;
				} else {
					max = count;
				}
			}
			
			int end = (i + K - 1) % N;
			if(cnt[sushi[end]] == 0) {
				count++;
			}
			cnt[sushi[end]]++;
			
			cnt[sushi[i-1]]--;
			if(cnt[sushi[i-1]] == 0) count--;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		System.out.println(max);
	}

}
