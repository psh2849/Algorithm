package etc;

import java.util.Scanner;

public class BOJ2902 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] str= s.split("-");
		
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i].charAt(0));
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		
	}

}
