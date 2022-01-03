package etc;

import java.util.*;

public class BOJ8595 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		String temp = "";
		long ans = 0;
		for(int i = 0; i < n; i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				temp += str.charAt(i);
			} else {
				if(temp.length() > 0) {
					ans += Long.parseLong(temp);
					temp = "";
				}
			}
		}
		
		if(temp.length() > 0) {
			ans += Long.parseLong(temp);
			temp = "";
		}
		
		System.out.println(ans);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
