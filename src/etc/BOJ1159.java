package etc;

import java.util.Scanner;

public class BOJ1159 {
	
	static int[] name = new int[123];
	static int n;
	static boolean isBool;
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			name[str.charAt(0)]++;
		}
		
		for(int i = 97; i < 123; i++) {
			if(name[i] >= 5) {
				System.out.print((char) i);
				isBool = true;
			}
		}
		
		if(!isBool) {
			System.out.println("PREDAJA");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
