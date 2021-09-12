/*
 * 2485. 가로수(최대공약수)
 */
package etc;

import java.util.Scanner;

public class BOJ2485 {
	static int N;
	static int[] num;
	static int[] dist;
	static int gcd = 0;
	static int ans = 0;
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dist = new int[N - 1];
		num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

	}
	static void pro() {
		for (int i = 0; i < N - 1; i++) {
			dist[i] = num[i + 1] - num[i];
		}

		gcd = gcd(dist[0], dist[1]);
		for (int i = 2; i < N - 2; i++) {
			gcd = gcd(gcd, dist[i]);
			if(gcd == 1) break;
		}
		
		for(int i = 0 ; i < N-1; i++) {
			ans += ((dist[i] / gcd) - 1);
		}
		
		System.out.println(ans);
	}
	
	static int gcd(int n1, int n2) {
		while (n2 > 0) {
			int temp = n2;
			n2 = n1 % n2;
			n1 = temp;
		}

		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
