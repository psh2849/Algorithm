package implementation;

import java.util.*;

public class BOJ4101 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == 0 && b == 0) {
				return;
			}
			
			if(a > b) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
