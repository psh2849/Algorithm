package etc;

import java.util.*;

public class BOJ2525 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int mod = c % 60;
		int div = c / 60;
		a += div;
		b += mod;
		
		if(b >= 60) {
			a++;
			b -= 60;
		}
		
		if(a >= 24) {
			a = a - 24;
		}
		
		System.out.println(a + " " + b);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
