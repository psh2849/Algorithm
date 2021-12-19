package etc;

import java.util.Scanner;

public class BOJ2810 {
	
	static int n;
	static String str;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		str = sc.next();
		
		int count = 1;
		for(int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			
			if(ch == 'S') {
				count++;
			}
			else if(ch == 'L') {
				i++;
				count++;
			}
		}
		
		if(count > n) {
			System.out.println(n);
		} else {
			System.out.println(count);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
