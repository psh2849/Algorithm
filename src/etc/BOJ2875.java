package etc;

import java.util.Scanner;

public class BOJ2875 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int min = 201;
		int max = 0;
		int copy_n = 0;
		int copy_m = 0;
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i + j == k) {
					copy_n = n - i;
					copy_m = m - j;
					
					copy_n = copy_n / 2;
					min = Math.min(copy_n, copy_m);
					max = Math.max(max, min);
				}
			}
		}
		
		System.out.println(max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
