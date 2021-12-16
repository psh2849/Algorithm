package implementation;

import java.util.*;

public class BOJ10162 {

	static void input() {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int a = t / 300;
		if(a != 0) {
			t = t % 300;
		}
		
		int b = t / 60;
		if(b != 0) {
			t = t % 60;
		}
		
		int c = t / 10;
		if(c != 0) {
			t = t % 10;
		}

		if(t != 0) {
			System.out.println(-1);
		} else {
			System.out.println(a + " " + b + " " + c);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
