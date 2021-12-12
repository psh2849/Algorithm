package etc;

import java.util.Scanner;

public class BOJ11365 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			if(str.equals("END")) {
				return;
			}
			
			StringBuilder sb = new StringBuilder();
			sb = sb.append(str).reverse();
			System.out.println(sb);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
