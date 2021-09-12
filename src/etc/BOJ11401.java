/*
 * BOJ11401. 이항 계수 3
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11401 {
	static int N, K;
	static final long INF = 1000000007;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		StringBuilder sb = new StringBuilder();
		
		long molecule = factorial(N);
		long denom = factorial(K) * factorial(N-K) % INF;
		
		
		sb.append(molecule * pow(denom, INF - 2) % INF);
		System.out.println(sb);
	}
	
	static long factorial(long N) {
		long fac = 1L;

		while (N > 1) {
			fac = (fac * N) % INF;
			N--;
		}
		
		return fac;
	}
	
	static long pow(long x, long y) {
		if(y== 1) {
			return x % INF;
		}
		
		long save = pow(x, y / 2);
		
		if(y % 2 == 1) {
			return (save * save % INF) * x % INF;
		}
		
		return save * save % INF;
		
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}

/*
 * n! / (n-k!) * k!
 */
